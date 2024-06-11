import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            
            int index = queue.poll();
            
            boolean isMax = true;
            for (int x : priorities) {
                if (x > priorities[index]) {
                    isMax = false;
                }
            }
            
            if (isMax) {
                priorities[index] = -1;
                answer++;
                if (index == location) {
                    return answer;
                }
            } else {
                queue.offer(index);
            }
            
        }
        
        return answer;
    }
}