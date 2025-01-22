import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] schedules = new int[N][2];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken()) + i;
            schedules[i][1] = Integer.parseInt(st.nextToken());
            if (schedules[i][0] <= N) {
               dp[i] = schedules[i][1];
            }
        }
        

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                
                // i번째날 상담완료 날짜가 N을 넘어가면 i번째날의 금액은 추가하지 않아야 한다.
                if (schedules[i][0] > N) {
                    continue;
                }

                if (schedules[j][0] > i && schedules[i][0] <= N) {
                    dp[i] = Math.max(dp[i], schedules[i][1]);
                }
                else {
                    // i가 j번째날 상담완료 날짜보다 크거나 같고, i번째날 상담완료 날짜가 N을 넘지 않으면
                    // dp[j]에 i번째날의 금액을 더한 것 중 가장 큰것이 최대 이익이다.
                    dp[i] = Math.max(dp[j] + schedules[i][1], dp[i]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int x : dp) {
            answer = Math.max(x, answer);
        }
        System.out.println(answer);
    }
}