import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int k = 1;
        Set<Integer> set = new HashSet<>();
        
        while (k <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += elements[(i + j) % elements.length];
                }
                if (!set.contains(sum)) {
                    set.add(sum);
                }
            }
            k++;
        }
        
        answer = set.size();
        
        return answer;
    }
}