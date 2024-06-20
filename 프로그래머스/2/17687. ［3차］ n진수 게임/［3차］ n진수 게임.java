import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String totalNums = "";
        
        for (int i = 0; i < t * m; i++) {
            totalNums += Integer.toString(i, n);
        }
        
        totalNums = totalNums.toUpperCase();
        
        for (int cnt = 0; cnt < t; cnt++) {
            answer += totalNums.charAt(p - 1);
            p += m;
        }
        
        return answer;
    }
}