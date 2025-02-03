import java.util.*;

class Solution {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public void bfs(int start) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        
        for (int x : graph.get(start)) {
            queue.offer(x);
        }
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (!visited[now]) {
                visited[now] = true;
                for (int x : graph.get(now)) {
                    queue.offer(x);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            List<Integer> now = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    now.add(j);
                }
            }
            graph.add(now);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i);
            }
        }
        
        return answer;
    }
}