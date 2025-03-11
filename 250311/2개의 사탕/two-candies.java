import java.util.*;
import java.io.*;

public class Main {

    // 오 -> 아래 -> 왼 -> 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int M;
    static int minCnt = Integer.MAX_VALUE;

    static void dfs (int cnt, char[][] graph, int redX, int redY, int blueX, int blueY) {
        if (cnt > 10) return;

        // 배열 복사
        char[][] newGraph = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newGraph[i][j] = graph[i][j];
                
            }
        }

        // System.out.println("현재 빨간사탕 위치 : "+red[0]+", "+red[1]);
        // System.out.println("현재 파란사탕 위치 : "+blue[0]+", "+blue[1]);

        for (int i = 0; i < 4; i++) {
            // 다음 빨간사탕 위치 찾기
            int nextRedX = redX;
            int nextRedY = redY;
            while (newGraph[nextRedX + dx[i]][nextRedY + dy[i]] != '#') {
                nextRedX += dx[i];
                nextRedY += dy[i];
                if (newGraph[nextRedX][nextRedY] == 'O') break;
            }

            // 다음 파란사탕 위치 찾기
            int nextBlueX = blueX;
            int nextBlueY = blueY;
            while (newGraph[nextBlueX+dx[i]][nextBlueY+dy[i]] != '#') {
                nextBlueX += dx[i];
                nextBlueY += dy[i];
                if (newGraph[nextBlueX][nextBlueY] == 'O') break;
            }
            

            if (newGraph[nextBlueX][nextBlueY] == 'O') continue;
            if (newGraph[nextRedX][nextRedY] == 'O') {
                minCnt = Math.min(minCnt, cnt);
                return;
            }
            // 아무것도 이동 안했으면 건너뜀
            if (redX == nextRedX && redY == nextRedY && blueX == nextBlueX && blueY == nextBlueY) continue;
            // 두 사탕 겹쳐도 안되고, 파란색이 O와 만나도 안되고
            if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
                int redDist = Math.abs(nextRedX - redX) + Math.abs(nextRedY - redY);
                int blueDist = Math.abs(nextBlueX - blueX) + Math.abs(nextBlueY - blueY);

                if (redDist > blueDist) {
                    nextRedX -= dx[i];
                    nextRedY -= dy[i];
                } else {
                    nextBlueX -= dx[i];
                    nextBlueY -= dy[i];
                }
            }
            
            dfs(cnt + 1, newGraph, nextRedX, nextRedY, nextBlueX, nextBlueY);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] graph = new char[N][M];
        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
                if (graph[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                }
                if (graph[i][j] == 'R') {
                    redX = i;
                    redY = j;
                }
            }
        }

        dfs(1, graph, redX, redY, blueX, blueY);

        if (minCnt == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(minCnt);
    }
}