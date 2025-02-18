import java.util.*;

class Solution {
    
    public int solution(int n, int[] money) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        // 0 1 2 3 4 5
        // 1 1 1 1 1 1 1일때
        // 1 1 2 2 3 3 2일때
        // 1 1 2 2 3 4 5일때
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] = (dp[i] + dp[i-m]) % 1_000_000_007;
            }
        }
        
        return dp[n];
    }
}