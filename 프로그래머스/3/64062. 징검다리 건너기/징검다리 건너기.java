import java.util.*;

class Solution {
    public static boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < mid) {
                cnt++;
                if (cnt >= k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = Integer.MAX_VALUE;
        int answer = 0;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            if (check(stones, k, mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
}