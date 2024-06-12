import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        String[] nums = {"4", "1", "2"};
        while (n > 0) {
            answer = nums[n % 3] + answer;
            if (n % 3 == 0) {
                n /= 3;
                n -= 1;
            } else {
                n /= 3;    
            }
            
        }
        
        return answer;
    }
}