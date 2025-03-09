import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], 1_000_000);
        }
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph[from][to] = cost;
            graph[to][from] = cost;
        }
        
        
        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] > graph[i][m] + graph[m][j]) {
                        graph[i][j] = graph[i][m] + graph[m][j];
                    }
                }
            }
        }
        
        for (int m = 1; m <= n; m++) {
            int nowCost = graph[s][m] + graph[m][a] + graph[m][b];
            answer = Math.min(answer, nowCost);
        }
        
        return answer;
    }
}