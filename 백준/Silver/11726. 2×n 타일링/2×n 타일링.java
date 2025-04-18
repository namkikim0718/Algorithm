import java.util.*;
import java.io.*;

public class Main {

    
    
    public static void main(String args[]) throws IOException {
        
        // N=1 -> 1
        // N=2 -> 2
        // N=3 -> 3
        // N=4 -> 5
        // N=5 -> 8 |||||, |||=, ||=|, |=||, =|||, |==, =|=, ==|, 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}