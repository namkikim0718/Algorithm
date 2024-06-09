import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> discountMap = new HashMap<>();
        Map<String, Integer> wantMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            discountMap.clear();
            for (int  j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean isPossible = true;
            for (int k = 0; k < want.length; k++) {
                if (wantMap.get(want[k]) != discountMap.getOrDefault(want[k], -99)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer++;
            }
        }
        
        return answer;
    }
}