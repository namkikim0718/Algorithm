import java.util.*;
import java.io.*;

public class Main {

    
    
    public static void main(String args[]) throws IOException {
        // dp[i] = dp[i-2] + wine[i] vs dp[i-3] + wine[i-1] + wine[i]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }
        if (n == 2) {
            System.out.println(wine[1] + wine[2]);
            return;
        }
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        for (int i = 3; i <= n; i++) {
            // 안마시는 것도 고려해야함
            dp[i] = Math.max(Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]), dp[i-1]);
        }
        
        System.out.println(dp[n]);
    }
}