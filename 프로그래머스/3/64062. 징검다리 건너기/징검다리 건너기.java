import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int answer = 0;
        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            boolean isAvailable = true;
            int jumpCnt = 0;
            
            for (int stone : stones) {
                if (stone < mid) {
                    jumpCnt++;
                    if (jumpCnt >= k) {
                        isAvailable = false;
                        break;
                    }
                } else {
                    jumpCnt = 0;
                }
            }
            
            if (isAvailable) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        
        return answer;
    }
}