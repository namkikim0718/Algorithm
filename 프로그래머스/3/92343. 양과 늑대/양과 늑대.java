import java.util.*;

class Solution {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static int maxCnt = 0;
    
    static void dfs(int[] info, int now, int sheep, int wolf, List<Integer> possible) {
        
        if (info[now] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        // 늑대가 양보다 많거나 같아지면 바로 중단.
        if (sheep <= wolf) {
            return;
        }
        
        maxCnt = Math.max(maxCnt, sheep);
        
        List<Integer> nextPossible = new ArrayList<>(possible);
        nextPossible.addAll(graph.get(now));
        nextPossible.remove(Integer.valueOf(now));
        
        // 가능 경로를 순회
        for (int next : nextPossible) {
            dfs(info, next, sheep, wolf, nextPossible);
        }
    }
    
    public int solution(int[] info, int[][] edges) {

        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        dfs(info, 0, 0, 0, new ArrayList<>());
        
        return maxCnt;
    }
}