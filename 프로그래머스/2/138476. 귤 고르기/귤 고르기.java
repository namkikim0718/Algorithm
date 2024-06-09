import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int x : tangerine) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        
        int sum = 0;
        int cnt = 0;
        for (int x : list) {
            sum += x;
            cnt ++;
            if (sum >= k) {
                break;
            }
        }
        
        return cnt;
    }
}