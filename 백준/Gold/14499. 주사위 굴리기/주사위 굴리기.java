import java.util.*;
import java.io.*;

public class Main {

    //            위, 앞, 아래, 뒤, 왼쪽, 오른쪽
    static int[] dice = { 0, 0, 0, 0, 0, 0 };


    // 북쪽으로 이동
    // 왼, 오 는 그대로. 위 -> 앞, 앞 -> 아래, 아래 -> 뒤, 뒤 -> 위
    static void moveNorth() {
        int up = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = up;
    }

    // 남쪽으로 이동
    // 왼, 오 는 그대로. 위 -> 뒤, 뒤 -> 아래, 아래 -> 앞, 앞 -> 위
    static void moveSouth() {
        int up = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = up;
    }

    // 동쪽으로 이동
    // 앞, 뒤는 그대로. 위 -> 왼, 왼 -> 아래, 아래 -> 오, 오 -> 위
    static void moveEast() {
        int up = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[2];
        dice[2] = dice[5];
        dice[5] = up;
    }

    // 서쪽으로 이동
    // 앞, 뒤는 그대로. 위 -> 오, 오 -> 아래, 아래 -> 왼, 왼 -> 위
    static void moveWest() {
        int up = dice[0];
        dice[0] = dice[5];
        dice[5] = dice[2];
        dice[2] = dice[4];
        dice[4] = up;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());
            boolean isAvailable = true;

            switch (command) {
                case 1:
                    if (y == M - 1) {
                        isAvailable = false;
                        break;
                    }
                    y++;
                    moveEast();
                    break;
                case 2:
                    if (y == 0) {
                        isAvailable = false;
                        break;
                    }
                    y--;
                    moveWest();
                    break;
                case 3:
                    if (x == 0) {
                        isAvailable = false;
                        break;
                    }
                    x--;
                    moveNorth();
                    break;
                case 4:
                    if (x == N - 1) {
                        isAvailable = false;
                        break;
                    }
                    x++;
                    moveSouth();
                    break;
            }

            if (!isAvailable) continue;

            if (graph[x][y] == 0) {
                graph[x][y] = dice[2];
            } else {
                dice[2] = graph[x][y];
                graph[x][y] = 0;
            }

            sb.append(dice[0] + "\n");
        }

        System.out.println(sb.toString().trim());

    }
}