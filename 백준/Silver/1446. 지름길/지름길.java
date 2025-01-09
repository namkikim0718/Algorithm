import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] shortCuts = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            shortCuts[i][0] = Integer.parseInt(st.nextToken());
            shortCuts[i][1] = Integer.parseInt(st.nextToken());
            shortCuts[i][2] = Integer.parseInt(st.nextToken());
        }

        // DP 일 가능성. . .
        int[] dp = new int[D+1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i-1] + 1);

            for (int[] shortCut : shortCuts) {
                int start = shortCut[0];
                int end = shortCut[1];
                int dist = shortCut[2];

                if (end > D) continue;

                dp[end] = Math.min(dp[end], dp[start]+dist);
            }
        }

        System.out.println(dp[D]);
    }
}