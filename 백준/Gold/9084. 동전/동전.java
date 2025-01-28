import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int j = 0; j < N; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M+1];
            // 1 2 3 4 5 6 : 1/2일때
            // 1 2 2 3 3
            // 1 2 3 4 5 6 : 1/3 일때
            // 1 1 2 2 2 3
            // 1 2 3 4 5 6 7 8 9 10 11 12 13 : 5/7 일때
            // 0 0 0 0 1 0 1 0 0 1  0  2  0
            dp[0] = 1; 

            // dp 배열을 먼저 순회하면서 동전별로 계산하려고 하면 올바른 결과가 나오지 않는다.
            // 동전을 기준으로 dp배열을 돌리면서 dp[k] 에 dp[k - coins[p]]를 더하면 각 동전의 경우의 수가 다 더해질 것이다.
            for (int p = 0; p < N; p++) {

                for (int k = coins[p]; k <= M; k++) {
                    dp[k] += dp[k - coins[p]];
                }
            }

            sb.append(dp[M] + "\n");
        }
        
        System.out.println(sb.toString().trim());

    }
}