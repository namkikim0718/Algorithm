import java.io.*;
import java.util.*;

class Solution {
    public boolean isCorrect(String str) {
        int leftCnt = 0;
        int rightCnt = 0;
        boolean result = true;
        
        for (char x: str.toCharArray()) {
            if (x == ')') {
                rightCnt++;
            } else if (x == '(') {
                leftCnt++;
            }
            
            if (leftCnt < rightCnt) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    
    public String solution(String p) {
        String answer = "";
        
        if (p.equals("")) return answer;
        
        char[] charArr = p.toCharArray();
        int cutIdx = 0;
        int leftCnt = 0;
        int rightCnt = 0;
        
        for (int i = 0; i < charArr.length; i++) {
            cutIdx++;
            if (charArr[i] == '(') {
                leftCnt++;
            } else if (charArr[i] == ')') {
                rightCnt++;
            }
            
            if (leftCnt == rightCnt) {
                break;
            }
        }
        
        String u = p.substring(0, cutIdx);
        String v = p.substring(cutIdx);
        
        if (isCorrect(u)) return u + solution(v);
        
        String newStr = "(" + solution(v) + ")";
        StringBuilder sb = new StringBuilder();
        
        for (char x : u.substring(1, u.length() - 1).toCharArray()) {
            if (x == '(') sb.append(')');
            else if (x == ')') sb.append('(');
        }
        
        return newStr + sb.toString();
        
    }
}