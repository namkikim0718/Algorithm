import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.toLowerCase().split(" ");
        String answer = "";
        
        for (String x : sArr) {
            if (x.length() == 0) {
                answer += " ";
            } else {
                answer += x.substring(0, 1).toUpperCase();
                answer += x.substring(1, x.length());
                answer += " ";
            }
        }
        
        if (s.substring(s.length() - 1, s.length()).equals(" ")) {
            return answer;
        }
        
        return answer.substring(0, answer.length() - 1);
    }
}