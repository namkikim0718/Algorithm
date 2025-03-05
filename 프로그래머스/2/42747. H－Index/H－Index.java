import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        Arrays.sort(citations);
        
        int h = citations[n - 1];
        
        // h 이상 인용된 논문이 h개 이상이어야 한다.
        // 나머지 논문이 모두 h번 이하 인용되어야 한다.
        for (int i = h; i >= 0; i--) {
            int upper = 0;
            for (int p = n - 1; p >= 0; p--) {
                if (citations[p] < i) break;
                upper++;
            }
            
            if (upper >= i) {
                return i;
            }
        }
        
        return 0;
    }
}