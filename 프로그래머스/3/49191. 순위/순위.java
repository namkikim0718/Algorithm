import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 뭔 알고리즘이더라. . .
        // 경유지를 기준으로 돌려서 그래프를 채워넣자.
        
        int[][] graph = new int[n+1][n+1];
        
        // 1이면 승리, -1이면 패배.
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }
        
        // k선수가 i 선수를 이기면 i선수에게 진 선수는 모두 k선수에게 진다.
        // k선수가 i 선수에게 지면 i선수에게 이긴 선수는 모두 k선수를 이긴다.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[k][i] == 1 && graph[i][j] == 1) {
                        graph[k][j] = 1;
                        graph[j][k] = -1;
                    } else if (graph[k][i] == -1 && graph[i][j] == -1) {
                        graph[k][j] = -1;
                        graph[j][k] = 1;
                    }
                }
            }
        }
        
        for (int[] row : graph) {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (row[i] == 0) cnt++;
            }
            // 자기 자신말고 모두 승패 결과가 정해진 사람은 순위를 매길 수 있음.
            if (cnt == 1) answer++;
        }
        return answer;
    }
}