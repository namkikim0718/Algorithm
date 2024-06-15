import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        String[] cache = new String[cacheSize];
        for (int i = 0; i < cacheSize; i++) {
            cache[i] = "null";
        }
        
        for (int i = 0; i < cities.length; i++) {
            boolean isHit = false;
            int hitIdx = -1;
            for (int j = 0; j < cacheSize; j++) {
                if (cache[j].equals(cities[i].toLowerCase())) {
                    isHit = true;
                    hitIdx = j;
                    break;
                }
            }
            if (isHit) {
                answer++;
                for (int k = hitIdx; k > 0; k--) {
                    cache[k] = cache[k-1];
                }
                cache[0] = cities[i].toLowerCase();
            } else {
                answer += 5;
                for (int k = cacheSize-1; k > 0; k--) {
                    cache[k] = cache[k-1];
                }
                cache[0] = cities[i].toLowerCase();
            }
        }
        
        return answer;
    }
}