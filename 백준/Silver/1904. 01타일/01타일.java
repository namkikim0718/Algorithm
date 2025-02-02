import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        // N = 1
        // 1 -> 1
        // N = 2
        // 11, 00 -> 2
        // N = 3
        // 111, 100, 001 -> 3
        // N = 4
        // 1111, 0000, 1100, 0011, 1001 -> 5
        // N = 5
        // 11111, 11100, 11001, 10011, 00111, 10000, 00100, 00001 -> 8
        // N = 6
        // 111111, 000000, 111100, 111001, 110011, 100111, 00111, 110000, 100001, 000011, 100100, 001100, 001001 -> 13
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}