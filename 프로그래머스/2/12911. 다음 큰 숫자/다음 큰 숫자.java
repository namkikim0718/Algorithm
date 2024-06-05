import java.util.*;

class Solution {
    
    public static boolean isPossible(int oneCnt, int nowNum) {
        String nowBinary = Integer.toBinaryString(nowNum);
        int nowCnt = 0;
        
        for (char x : nowBinary.toCharArray()) {
            if (x == '1') {
                nowCnt++;
            }
        }
        if (nowCnt == oneCnt) {
            return true;
        }
        return false;
    }
    
    public int solution(int n) {
        String nBinary = Integer.toBinaryString(n);
        int nCnt = 0;
        
        for (char x : nBinary.toCharArray()) {
            if (x == '1') {
                nCnt++;
            }
        }
        
        int nowNum = n+1;
        while (!isPossible(nCnt, nowNum)) {
            nowNum++;
        }
        
        return nowNum;
    }
}