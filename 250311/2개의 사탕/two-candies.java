import java.util.*;
import java.io.*;

public class Main {

    // 오 -> 아래 -> 왼 -> 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int M;
    static int minCnt = Integer.MAX_VALUE;

    static void dfs (int cnt, char[][] graph) {
        if (cnt > 10) return;

        // 배열 복사
        char[][] newGraph = new char[N][M];
        int[] red = new int[2];
        int[] blue = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newGraph[i][j] = graph[i][j];
                if (graph[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                if (graph[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
            }
        }

        // System.out.println("현재 빨간사탕 위치 : "+red[0]+", "+red[1]);
        // System.out.println("현재 파란사탕 위치 : "+blue[0]+", "+blue[1]);

        for (int i = 0; i < 4; i++) {
            // 다음 빨간사탕 위치 찾기
            int nextRedX = red[0];
            int nextRedY = red[1];
            while (nextRedX + dx[i] >= 0 && nextRedX + dx[i] < N && nextRedY + dy[i] >= 0 && nextRedY + dy[i] < M && newGraph[nextRedX + dx[i]][nextRedY + dy[i]] != '#') {
                nextRedX += dx[i];
                nextRedY += dy[i];
                if (newGraph[nextRedX][nextRedY] == 'O') break;
            }

            // 다음 파란사탕 위치 찾기
            int nextBlueX = blue[0];
            int nextBlueY = blue[1];
            while (nextBlueX + dx[i] >= 0 && nextBlueX + dx[i] < N && nextBlueY + dy[i] >= 0 && nextBlueY + dy[i] < M && newGraph[nextBlueX+dx[i]][nextBlueY+dy[i]] != '#') {
                nextBlueX += dx[i];
                nextBlueY += dy[i];
                if (newGraph[nextBlueX][nextBlueY] == 'O') break;
            }
            

            if (newGraph[nextBlueX][nextBlueY] == 'O') continue;
            if (newGraph[nextRedX][nextRedY] == 'O') {
                minCnt = Math.min(minCnt, cnt + 1);
                return;
            }
            // 아무것도 이동 안했으면 건너뜀
            if (red[0] == nextRedX && red[1] == nextRedY && blue[0] == nextBlueX && blue[1] == nextBlueY) continue;
            // 두 사탕 겹쳐도 안되고, 파란색이 O와 만나도 안되고
            if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
                int redDist = Math.abs(nextRedX - red[0]) + Math.abs(nextRedY - red[1]);
                int blueDist = Math.abs(nextBlueX - blue[0]) + Math.abs(nextBlueY - blue[1]);

                if (redDist > blueDist) {
                    nextRedX -= dx[i];
                    nextRedY -= dy[i];
                } else {
                    nextBlueX -= dx[i];
                    nextBlueY -= dy[i];
                }
            }
            

            newGraph[red[0]][red[1]] = '.';
            newGraph[blue[0]][blue[1]] = '.';
            newGraph[nextRedX][nextRedY] = 'R';
            newGraph[nextBlueX][nextBlueY] = 'B';
            dfs(cnt + 1, newGraph);
            newGraph[red[0]][red[1]] = 'R';
            newGraph[blue[0]][blue[1]] = 'B';
            newGraph[nextRedX][nextRedY] = '.';
            newGraph[nextBlueX][nextBlueY] = '.';

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        dfs(0, graph);

        if (minCnt == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(minCnt);
    }
}