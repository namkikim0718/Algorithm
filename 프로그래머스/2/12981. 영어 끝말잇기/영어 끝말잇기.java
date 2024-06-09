import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < words.length; i++) {
            if (!stack.isEmpty()) {
                if (!stack.contains(words[i])) {
                    String before = stack.peek();
                    
                    if (before.charAt(before.length()-1) != words[i].charAt(0)) {
                        if (i % n == n - 1) {
                            answer[0] = n;
                        } else {
                            answer[0] = i % n + 1;
                        }
                        answer[1] = i / n + 1;
                        break;
                    } else {
                        stack.push(words[i]);
                    }
                } else {
                    if (i % n == n - 1) {
                            answer[0] = n;
                        } else {
                            answer[0] = i % n + 1;
                        }
                        answer[1] = i / n + 1;
                        break;
                }
            } else {
                stack.push(words[i]);
            }
        }

        return answer;
    }
}