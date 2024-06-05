import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        for (int i = 3; i <= sum; i++) {
            if (sum % i == 0) {
                int j = sum / i;
                if (j >= i) {
                    if ((j-2) * (i-2) == yellow) {
                        answer[0] = j;
                        answer[1] = i;
                        break;
                    }
                }
            }
        }
    
        
        return answer;
    }
}