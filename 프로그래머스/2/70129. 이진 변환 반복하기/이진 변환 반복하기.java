import java.util.*;

class Solution {
    static int tryCnt = 0;
    static int zeroCnt = 0;
    
    public static String change(String s) {
        int sum = 0;
        
        for (char x : s.toCharArray()) {
            if (x != '0') {
                sum++;
            } else {
                zeroCnt++;
            }
        }
        return Integer.toBinaryString(sum);
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (s.length() > 1) {
            s = change(s);
            tryCnt++;
        }
        
        answer[0] = tryCnt;
        answer[1] = zeroCnt;
        return answer;
    }
}