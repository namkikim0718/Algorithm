import java.util.*;
import java.io.*;

public class Main {

    static boolean[] base = new boolean[4];
    static int[][] plays;
    static int[] order = new int[9];
    static int N;
    static int maxScore = 0;

    static void permute(int depth, boolean[] visited) {
        if (depth == 9) {
            maxScore = Math.max(maxScore, playGame());
            return;
        }

        if (depth == 3) {
            permute(depth + 1, visited);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                permute(depth + 1, visited);
                visited[i] = false;
            }
        }
    }

    static int playGame() {
        int score = 0;
        int playerIdx = 0;
        
        for (int inning = 0; inning < N; inning++) {
            int outCount = 0;
            boolean[] bases = new boolean[4];

            while (outCount < 3) {
                int batter = order[playerIdx];
                int value = plays[inning][batter];

                if (value == 0) {
                    outCount++;
                } else {
                    for (int i = 3; i > 0; i--) {
                        if (bases[i]) {
                            if (i + value >= 4) score++;
                            else bases[i + value] = true;
                            bases[i] = false;
                        }
                    }

                    if (value == 4) score++;
                    else bases[value] = true;
                }

                playerIdx = (playerIdx + 1) % 9;
            }
        }

        return score;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        plays = new int[N][9];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                plays[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permute(0, new boolean[9]);

        System.out.println(maxScore);

    }
}