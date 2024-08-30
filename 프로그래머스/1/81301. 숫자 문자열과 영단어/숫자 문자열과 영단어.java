import java.util.*;

class Solution {
    
    public int strToNum(StringBuilder sb) {
        int result = -1;
        switch (sb.toString()) {
            case "zero" : 
                result = 0;
                break;
            case "one" : 
                result = 1;
                break;
            case "two" : 
                result = 2;
                break;
            case "three" :
                result = 3;
                break;
            case "four" : 
                result = 4;
                break;
            case "five" : 
                result = 5;
                break;
            case "six" : 
                result = 6;
                break;
            case "seven" : 
                result = 7;
                break;
            case "eight" :
                result = 8;
                break;
            case "nine" : 
                result = 9;
                break;
        }
        return result;
    }
    
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for (char x : s.toCharArray()) {
            // 숫자면 answer에 바로 추가
            if (Character.isDigit(x)) {
                answer.append(x);
                continue;
            }
            
            // sb에 글자를 모아둠
            sb.append(x);
            // 숫자로 변환할 수 있는지 체크
            int nowN = strToNum(sb);
            
            // 숫자로 변환못하면 넘어감
            if (nowN == -1) {
                continue;
            }
            
            // 숫자로 변환되면 answer에 추가하고 sb 초기화
            answer.append(nowN);
            sb = new StringBuilder();
            
        }
        
        
        return Integer.parseInt(answer.toString());
    }
}