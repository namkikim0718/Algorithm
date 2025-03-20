import java.util.*;

class Solution {
    
    static int maxCnt = Integer.MIN_VALUE;
    
    static void recursion(int nowK, int[][] dungeons, boolean[] visited, int cnt) {
        
        boolean isAllVisited = true;
        boolean[] newVisited = new boolean[visited.length];
        for (int i = 0; i < visited.length; i++) {
            newVisited[i] = visited[i];
            if (!visited[i]) {
                isAllVisited = false;
            }
        }
        
        if (isAllVisited) {
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!newVisited[i]) {
                newVisited[i] = true;
                if (dungeons[i][0] <= nowK) {
                    recursion(nowK - dungeons[i][1], dungeons, newVisited, cnt+1);
                } else {
                    recursion(nowK, dungeons, newVisited, cnt);
                }
                newVisited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        
        recursion(k, dungeons, new boolean[dungeons.length], 0);
        
        return maxCnt;
    }
}