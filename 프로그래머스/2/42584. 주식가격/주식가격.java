import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    cnt++;
                } else {
                    cnt++;
                    break;
                }
            }
            if(cnt == 0) {
                cnt = 1;
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}