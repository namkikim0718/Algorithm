import java.util.*;
import java.io.*;

public class Main {

    static int R;
    static int C;
    static int T;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int upperPurifier = -1;
    static int lowerPurifier = -1;

    static void diffusion() {
        int[][] newGraph = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (graph[x][y] != 0 && graph[x][y] != -1) {
                    int diffuseAmount = graph[x][y] / 5;
                    int diffuseCnt = 0;

                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && graph[nx][ny] != -1) {
                            diffuseCnt++;
                            newGraph[nx][ny] += diffuseAmount;
                        }
                    }

                    newGraph[x][y] -= diffuseAmount * diffuseCnt;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                graph[i][j] = newGraph[i][j];
            }
        }
    }

    static void purification() {
        // 위쪽 먼저
        // 아래
        for (int i = upperPurifier - 2; i >= 0; i--) {
            graph[i + 1][0] = graph[i][0];
        }
        // 왼쪽으로
        for (int i = 1; i < C; i++) {
            graph[0][i - 1] = graph[0][i];
        }
        // 위
        for (int i = 1; i <= upperPurifier; i++) {
            graph[i - 1][C - 1] = graph[i][C - 1];
        }
        // 오른쪽으로
        for (int i = C - 1; i > 1; i--) {
            graph[upperPurifier][i] = graph[upperPurifier][i - 1];
        }
        graph[upperPurifier][1] = 0; // 미세먼지 없는 바람 나옴

        // 아래쪽 공기청정기 처리
        // 위
        for (int i = lowerPurifier + 2; i < R; i++) {
            graph[i - 1][0] = graph[i][0];
        }
        // 왼쪽으로
        for (int i = 1; i < C; i++) {
            graph[R - 1][i - 1] = graph[R - 1][i];
        }
        // 아래
        for (int i = R - 1; i > lowerPurifier; i--) {
            graph[i][C - 1] = graph[i - 1][C - 1];
        }
        // 오른쪽으로
        for (int i = C - 1; i > 1; i--) {
            graph[lowerPurifier][i] = graph[lowerPurifier][i - 1];
        }
        graph[lowerPurifier][1] = 0;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 50 * 50 * 1000 = 2,500,000 완탐 가능.
        // T초 동안 각 칸에 대해서 확산되는거 처리. (1)
        // 공기 청정기가 작동 위에꺼, 밑에꺼 차례대로 처리 (2)
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        graph = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    if (upperPurifier == -1) {
                        upperPurifier = i;
                    } else {
                        lowerPurifier = i;
                    }
                }
            }
        }

        for (int t = 0; t < T; t++) {
            diffusion();

            purification();

        }

        int total = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                total += graph[i][j];
            }
        }
        System.out.println(total);

    }
}