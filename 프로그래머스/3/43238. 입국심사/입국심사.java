import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        
        long left = 1;
        long right = n * maxTime;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long availableCnt = 0;
            for (int time : times) {
                availableCnt += mid / time;
            }
            
            if (availableCnt < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}