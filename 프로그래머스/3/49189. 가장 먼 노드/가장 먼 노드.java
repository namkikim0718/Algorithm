import java.util.*;

class Solution {
    
    static int[] bfs(int n, int[][] edges, List<List<Integer>> graph) {
        int[] visited = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[1] = 1;
        queue.offer(1);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int nextNode : graph.get(node)) {
                if (visited[nextNode] != 0) continue;
                queue.offer(nextNode);
                visited[nextNode] = visited[node] + 1;
            }
        }
        
        return visited;
    }
    
    public int solution(int n, int[][] edges) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dists = bfs(n, edges, graph);
        int maxDist = Integer.MIN_VALUE;
        for (int dist : dists) {
            maxDist = Math.max(maxDist, dist);
        }
        
        for (int dist : dists) {
            if (dist == maxDist) {
                answer++;
            }
        }
        
        return answer;
    }
}