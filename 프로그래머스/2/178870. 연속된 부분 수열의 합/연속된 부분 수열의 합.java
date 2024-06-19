import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int lt = 0;
        int rt = sequence.length - 1;
        int sum = 0;
        
        int j = 0;
        for (int i = 0; i < sequence.length; i++) {

            
            while (j < sequence.length && sum < k) {
                sum += sequence[j++];
            }
            
            if (sum == k) {
                if (rt - lt > j - i - 1) {
                    rt = j - 1;
                    lt = i;
                }
            }
            
            sum -= sequence[i];
        }
        
        answer[0] = lt;
        answer[1] = rt;
        
        return answer;
    }
}