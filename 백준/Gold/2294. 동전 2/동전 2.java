import java.util.*;
import java.io.*;

public class Main {


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 10_001);
        dp[0] = 0;
        Arrays.sort(coins);

        for (int i = 1; i <= K; i++) {
            for (int k = 0; k < N; k++) {
                
                if (coins[k] > i) break;

                dp[i] = Math.min(dp[i - coins[k]] + 1, dp[i]);
            }
        }

        if (dp[K] == 10_001) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[K]);

    }
}
