import java.util.*;
import java.io.*;

public class Main {

    static List<List<int[]>> graph = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++)  {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, cost});
        }

        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 10_000_000;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int[] x : graph.get(i)) {
                int end = x[0];
                int cost = x[1];
                dp[i][end] = Math.min(dp[i][end], cost);
            }
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {       
                    dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid][end]);
                }
            }
        }

        for (int start = 1; start <= n; start++) {
            for (int end = 1; end <= n; end++) {
                if (dp[start][end] == 10_000_000) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(dp[start][end] + " ");
            }
            System.out.println();
        }
    }
}