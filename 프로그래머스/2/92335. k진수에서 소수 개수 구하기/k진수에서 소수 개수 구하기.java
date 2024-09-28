import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n, k);
        String[] numStrList = str.split("0");
        for (String x : numStrList) {
            if (x.equals("") || x.equals("1")) continue;
            
            long now = Long.parseLong(x);
            
            boolean isPrime = true;
            for (int i = 2; i <= (int)Math.sqrt(now); i++) {
                if (now % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                answer++;
            }
        }
        
        return answer;
    }
}