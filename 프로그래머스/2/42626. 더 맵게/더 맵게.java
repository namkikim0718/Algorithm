import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int x : scoville) {
            queue.offer(x);
        }
        
        while(queue.size() >= 2) {
            int A = queue.poll();
            if (A >= K) {
                return answer;
            }
            int B = queue.poll();
            
            int C = A + B*2;
            queue.offer(C);
            answer++;
        }
        if (queue.poll() < K) {
            return -1;
        } else {
            return answer;
        }
    }
}