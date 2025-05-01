import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
