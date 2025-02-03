import java.util.*;

class Solution {
    public int solution(int N, int number) {

        // dp[1]
        // {5}
        // dp[2]
        // {55, 5+5, 5-5, 5*5, 5/5}
        // dp[3]
        // {555, 55+5, 55-5, 55*5, 55/5, 5+5+5, 5-5+5, 5*5+5, 5/5+5, ...}
        // i만큼 이어붙인거랑, dp[i-1]에 있는거 각각에 dp[i-2]에 있는걸 사칙연산 계산한 것
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int i = 1; i < 9; i++) {
            int repeat = N;
            for (int k = i-1; k > 0; k--) {
                repeat += N * Math.pow(10, k);
            }
            dp.get(i).add(repeat);
            
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i-j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) dp.get(i).add(num1 / num2);
                    }
                }
            }
            
            if (dp.get(i).contains(number)) return i;
        }
        
        
        return -1;
    }
}