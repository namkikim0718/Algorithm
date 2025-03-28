import java.util.*;

class Solution {
    public int solution(int n) {
        
        // 카탈란 수 문제
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i-j] * dp[j-1];
            }
        }
        
        return dp[n];
    }
}