import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String answerStr = "";
        
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        int idx = 0;
        String tmp = "";
        while (idx < s.length()) {
            char now = s.charAt(idx);
            if (Character.isDigit(now)) {
                answerStr += now;
            } else {
                tmp += now;
                for (int i = 0; i < str.length; i++) {
                    String x = str[i];
                    if (x.equals(tmp)) {
                        answerStr+= i;
                        tmp = "";
                        break;
                    }
                }
            }
            idx++;
        }
        
        answer = Integer.parseInt(answerStr);
        
        return answer;
    }
}