import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int maxValue = Integer.MIN_VALUE;

    static void dfs(int[][] graph, int depth) {
        

        int nowMaxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nowMaxValue = Math.max(nowMaxValue, graph[i][j]);
            }
        }

        if (depth == 5) {
            maxValue = Math.max(maxValue, nowMaxValue);
            return;
        }

        // 윗 방향
        int[][] newGraph1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGraph1[i][j] = graph[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                int otherBlock = i + 1;
                while (otherBlock + 1 < n && newGraph1[otherBlock][j] == 0) {
                    otherBlock++;
                }

                if (newGraph1[i][j] == newGraph1[otherBlock][j]) {
                    newGraph1[i][j] *= 2;
                    newGraph1[otherBlock][j] = 0;
                    i = otherBlock;
                } else {
                    i = otherBlock - 1;
                }
            }
            

            for (int i = 1; i < n; i++) {
                if (newGraph1[i][j] == 0) continue;
                int nextIdx = i;
                while (nextIdx - 1 >= 0 && newGraph1[nextIdx - 1][j] == 0) {
                    nextIdx--;
                }

                if (newGraph1[nextIdx][j] == 0) {
                    newGraph1[nextIdx][j] = newGraph1[i][j];
                    newGraph1[i][j] = 0;
                }
            }
        }
        
        dfs(newGraph1, depth + 1);

        // 아래 방향
        int[][] newGraph2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGraph2[i][j] = graph[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i > 0; i--) {
                int otherBlock = i - 1;
                while (otherBlock - 1 >= 0 && newGraph2[otherBlock][j] == 0) {
                    otherBlock--;
                }

                if (newGraph2[i][j] == newGraph2[otherBlock][j]) {
                    newGraph2[i][j] *= 2;
                    newGraph2[otherBlock][j] = 0;
                    i = otherBlock;
                } else {
                    i = otherBlock + 1;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (newGraph2[i][j] == 0) continue;
                int nextIdx = i;
                while (nextIdx + 1 < n && newGraph2[nextIdx + 1][j] == 0) {
                    nextIdx++;
                }
                if (newGraph2[nextIdx][j] == 0) {
                    newGraph2[nextIdx][j] = newGraph2[i][j];
                    newGraph2[i][j] = 0;    
                }
            }
        }
        dfs(newGraph2, depth + 1);

        // 오른쪽 방향
        int[][] newGraph3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGraph3[i][j] = graph[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > 0; j--) {
                int otherBlock = j - 1;
                while (otherBlock - 1 >= 0 && newGraph3[i][otherBlock] == 0) {
                    otherBlock--;
                }

                if (newGraph3[i][j] == newGraph3[i][otherBlock]) {
                    newGraph3[i][j] *= 2;
                    newGraph3[i][otherBlock] = 0;
                    j = otherBlock;
                } else {
                    j = otherBlock + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (newGraph3[i][j] == 0) continue;
                int nextIdx = j;
                while (nextIdx + 1 < n && newGraph3[i][nextIdx + 1] == 0) {
                    nextIdx++;
                }
                if (newGraph3[i][nextIdx] == 0) {
                    newGraph3[i][nextIdx] = newGraph3[i][j];
                    newGraph3[i][j] = 0;
                }
            }
        }
        dfs(newGraph3, depth + 1);

        // 왼쪽 방향
        int[][] newGraph4 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGraph4[i][j] = graph[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int otherBlock = j + 1;
                while (otherBlock + 1 < n && newGraph4[i][otherBlock] == 0) {
                    otherBlock++;
                }

                if (newGraph4[i][j] == newGraph4[i][otherBlock]) {
                    newGraph4[i][j] *= 2;
                    newGraph4[i][otherBlock] = 0;
                    j = otherBlock;
                } else {
                    j = otherBlock - 1;
                }
            }

            for (int j = 1; j < n; j++) {
                if (newGraph4[i][j] == 0) continue;
                int nextIdx = j;
                while (nextIdx - 1 >= 0 && newGraph4[i][nextIdx - 1] == 0) {
                    nextIdx--;
                }
                if (newGraph4[i][nextIdx] == 0) {
                    newGraph4[i][nextIdx] = newGraph4[i][j];
                    newGraph4[i][j] = 0;
                }
            }
        }
        dfs(newGraph4, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        
        // 지정된 방향의 가장 끝 지점에서부터 0인 경우는 건너뛰고, 두개의 숫자를 비교해서 같으면 더하자.
        // 더한 경우 더 먼 인덱스 + 1로 바로 넘어가고, 더하지 않으면 먼 인덱스에서부터 다시 탐색하자.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(graph, 0);

        System.out.println(maxValue);
    }
}