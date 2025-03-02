import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int work : works) {
            pq.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            int maxWork = pq.poll();
            maxWork--;
            pq.offer(maxWork);
        }
        
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (now <= 0) continue;
            answer += Math.pow(now, 2);
        }
        
        return answer;
    }
}