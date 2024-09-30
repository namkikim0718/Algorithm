import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int x : queue1) {
            q1.offer(x);
            sum1 += x;
        }
        for (int x : queue2) {
            q2.offer(x);
            sum2 += x;
        }
        
        long need = (sum1 + sum2) / 2;
        int cnt = 0;
        
        while (sum1 != need || sum2 != need) {
            
            if (cnt > (queue1.length + queue2.length) * 2) return -1;
            
            if (sum1 > need) {
                int now = q1.poll();
                if (now > need) return -1;
                q2.offer(now);
                sum1 -= now;
                sum2 += now;
            } else {
                if (q2.isEmpty()) return -1;
                int now = q2.poll();
                if (now > need) return -1;
                q1.offer(now);
                sum2 -= now;
                sum1 += now;
            }
            
            cnt++;
        }
        
        
        
        
        return cnt;
    }
}