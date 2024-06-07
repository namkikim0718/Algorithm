import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        int pCnt = 0;
        int yCnt = 0;
        
        for (char x : s.toLowerCase().toCharArray()) {
            if (x == 'p') {
                pCnt++;
            } else if (x == 'y') {
                yCnt++;
            }
        }

        if (pCnt == 0 && yCnt == 0) {
            answer = true;
        } else if (pCnt == yCnt) {
            answer = true;
        } else {
            answer = false;
        }
        
        
        return answer;
    }
}