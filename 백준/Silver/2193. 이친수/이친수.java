import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {
        
        // N = 2 -> 1
        // 10
        // N = 3 -> 2
        // 101, 100
        // N = 4 -> 3
        // 1010, 1001, 1000
        // N = 5 -> 5
        // 10101, 10010, 10000, 10100, 10001, 
        // N = 6 -> 8
        // 100000, 100001, 100010, 100100, 100101, 101000, 101001, 101010
        // N = 7 -> 13
        // 1000000, 1000001, 1000010, 1000100, 1000101, 101000, 1001001, 1001010, 1010000, 1010001, 1010010, 1010100, 1010101
        // 결국 다시보면 dp[i-1] + dp[i-2]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        // 설마 int로 해서 안되나. . 
        long[] dp = new long[N+1];
        dp[1] = 1;
        

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}