import java.util.*;
import java.io.*;

public class Main {

    
    
    public static void main(String args[]) throws IOException {
        // N=0 -> 1 0
        // N=1 -> 0 1
        // N=2 -> 1 1
        // N=3 -> 1 2
        // N=4 -> 2 3
        // N=5 -> 3 5
        // N=6 -> 5 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0] + " " + dp[N][1] + "\n");
        }

        System.out.println(sb.toString().trim());
        
    }
}