import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = Arrays.copyOf(arr, N+1);

        // N-1번째랑 1번째랑 더한거랑
        // N- N/2번째랑 N-N/2번째랑 더한거
        for (int i = 2; i <= N; i++) {
            int maxSum = Integer.MIN_VALUE;
            for (int k = 1; k <= i/2; k++) {
                maxSum = Math.max(maxSum, dp[k] + dp[i-k]);
            }
            dp[i] = Math.max(dp[i], maxSum);
        }

        System.out.println(dp[N]);

    }
}