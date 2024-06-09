import java.util.*;

class Solution {
    
    public static boolean isPossible(Queue<Character> input) {
        Stack<Character> stack = new Stack<>(); 
        for (char x : input) {
            
            if (!stack.isEmpty()) {
                char now = stack.peek();
                if (x == ')' && now == '(') {
                    stack.pop();
                } else if (x == '}' && now == '{') {
                    stack.pop();
                } else if (x == ']' && now == '[') {
                    stack.pop();
                } else {
                    stack.push(x);
                }
            } else {
                stack.push(x);
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    public int solution(String s) {
        
        int cnt = 0;
        
        Queue<Character> queue = new LinkedList<>();
        for (char x : s.toCharArray()) {
            queue.offer(x);
        }
        System.out.println(queue.toString());
        
        for (int i = 0; i < s.length(); i++) {
            queue.offer(queue.poll());
            if (isPossible(queue)) {
                cnt++;
            }
        }
        
        return cnt;
    }
}