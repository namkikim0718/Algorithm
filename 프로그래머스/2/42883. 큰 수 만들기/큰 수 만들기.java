import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int nowIdx = 0;
        int maxIdx = 0;
        int eliminateNum = k;
        while (answer.length() + eliminateNum < number.length()) {
            
            int maxValue = Integer.MIN_VALUE;
            
            for (int i = nowIdx; i < nowIdx + k + 1; i++) {
                if (i < number.length() && Character.getNumericValue(number.charAt(i)) > maxValue) {
                    maxIdx = i;
                    maxValue = Character.getNumericValue(number.charAt(i));
                    if (maxValue == 9) {
                        break;
                    }
                }
            }
            
            int cnt = maxIdx - nowIdx;
            nowIdx = maxIdx;
            
            k -= cnt;
            answer += String.valueOf(number.charAt(nowIdx++));
        }

       
        
        return answer;
    }
}