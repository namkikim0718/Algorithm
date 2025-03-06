import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        long minCost = Integer.MAX_VALUE;
        
        // 플로이드-워셜 (다익스트라는 특정 지점부터 특정 지점까지의 최단거리)
        // 모든 정점간의 최단 거리를 구하고,
        // 시작점부터 함께 가는 곳을 기준으로 비용을 계산하고, 그 경유지부터 각 목적지까지의 비용을 더하면 된다.
        long[][] dist = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            dist[from][to] = cost;
            dist[to][from] = cost;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        for (int with = 1; with <= n; with++) {
            minCost = Math.min(minCost, dist[s][with] + dist[with][a] + dist[with][b]);
        }
        
        return (int) minCost;
    }
}