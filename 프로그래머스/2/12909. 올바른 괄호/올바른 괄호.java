import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push('(');
            } else if (x == ')') {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}