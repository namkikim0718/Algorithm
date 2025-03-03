import java.util.*;

class Solution {
    
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean isFinished = false;
    static int totalCost = 0;
    static int[] parent;
    
    static void merge(int[][] land, int areaCnt) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        
        for (int x = 0; x < land.length; x++) {
            for (int y = 0; y < land.length; y++) {                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (nx >= 0 && nx < land.length && ny >= 0 && ny < land.length && 
                        visited[nx][ny] != visited[x][y]) {
                        pq.offer(new int[]{visited[x][y], visited[nx][ny], Math.abs(land[nx][ny] - land[x][y])});
                    }
                }
            }
        }
        
        int edgeCnt = 0;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int from = now[0];
            int to = now[1];
            int cost = now[2];
            
            int parentFrom = findParent(from);
            int parentTo = findParent(to);
            if (parentFrom != parentTo) {
                parent[parentFrom] = parentTo;
                edgeCnt++;
                totalCost += cost;
                
                if (edgeCnt >= areaCnt) return;
            }
        }
    }
    
    static void bfs(int[][] land, int height, int area, int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        visited[a][b] = area;
        queue.offer(new int[]{a, b});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land.length && visited[nx][ny] == 0) {
                    if (Math.abs(land[nx][ny] - land[x][y]) <= height) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = area;
                    }
                }
            }
        }
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (visited[i][j] == 0) {
                    return;
                }
            }
        }
        
        isFinished = true;
        
    }
    
    static int findParent(int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
    
    public int solution(int[][] land, int height) {
        int n = land.length;
        
        visited = new int[n][n];
        
        int area = 1;
        while (!isFinished) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        bfs(land, height, area++, i, j);
                    }
                }
            }
        }
        
        parent = new int[area];
        for (int i = 1; i < area; i++) {
            parent[i] = i;
        }
        
        merge(land, area);
        
        return totalCost;
    }
}