import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        int n = genres.length;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
        }
        
        while (!map.isEmpty()) {
            String maxGenre = "";
            int maxCnt = 0;
            for (String key : map.keySet()) {
                if (maxCnt < map.get(key)) {
                    maxCnt = map.get(key);
                    maxGenre = key;
                }
            }
            
            map.remove(maxGenre);
            
            List<int[]> nowList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (genres[i].equals(maxGenre)) {
                    nowList.add(new int[]{plays[i], i});
                }
            }
            
            Collections.sort(nowList, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            });
            
            int songCnt = 0;
            for (int[] now : nowList) {
                answer.add(now[1]);
                songCnt++;
                if (songCnt >= 2) break;
            }
        }
        
        return answer;
    }
}