import java.util.*;

class Solution {
    
    static int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }
    
    public int solution(int n, int[][] costs) {
        // MST 알고리즘(유니온 파인드)
        
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        int edgeCnt = 0;
        
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int nowCost = cost[2];
            
            int parentFrom = findParent(parent, from);
            int parentTo = findParent(parent, to);
            
            if (parentFrom != parentTo) {
                parent[parentTo] = parentFrom;
                totalCost += nowCost;
                edgeCnt++;
            }
            
            if (edgeCnt == n - 1) {
                break;
            }
        }
        
        return totalCost;
    }
}