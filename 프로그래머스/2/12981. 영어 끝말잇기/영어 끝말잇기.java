import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String now = words[i];
            String before = words[i-1];
            
            if (before.charAt(before.length() - 1) != now.charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            if (set.contains(now)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            set.add(now);
        }

        return answer;
    }
}