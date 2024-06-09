import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = Integer.MIN_VALUE;
        
        for (int i = 0; i < citations.length; i++) {
            int now = citations[i];
            
            int tmp = Math.min(citations.length - i, citations[i]);
            hIndex = Math.max(hIndex, tmp);
        }
        
        return hIndex;
    }
}