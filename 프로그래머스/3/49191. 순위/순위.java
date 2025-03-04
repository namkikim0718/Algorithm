import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }
        
        // 경유하는 선수를 중심으로 해보자.
        // A, B, C가 있을때
        // A가 B를 이기고 B가 C를 이기면 A는 C를 이긴다
        // A가 B에게 지고 B가 C에게 지면 A는 C에게 진다
        for (int B = 1; B <= n; B++) {
            for (int A = 1; A <= n; A++) {
                for (int C = 1; C <= n; C++) {
                    if (graph[A][B] == 1 && graph[B][C] == 1) {
                        graph[A][C] = 1;
                        graph[C][A] = -1;
                    } else if (graph[A][B] == -1 && graph[B][C] == -1) {
                        graph[A][C] = -1;
                        graph[C][A] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int resultCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) resultCnt++;
            }
            if (resultCnt == n - 1) answer++;
        }
        return answer;
    }
}