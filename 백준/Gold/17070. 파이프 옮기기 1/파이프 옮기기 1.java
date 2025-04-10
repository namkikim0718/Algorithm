import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph;
    static int result = 0;

    static void dfs(int x1, int y1, int x2, int y2) {

        if (x2 == N - 1 && y2 == N - 1) {
            result++;
            return;
        }

        // 가로
        if (x1 == x2) {
            if (y2 + 1 < N && graph[x2][y2 + 1] == 0) {
                dfs(x1, y1 + 1, x2, y2 + 1);
            }
            if (y2 + 1 < N && x2 + 1 < N && graph[x2 + 1][y2 + 1] == 0 && graph[x2 + 1][y2] == 0 && graph[x2][y2 + 1] == 0) {
                dfs(x1, y1 + 1, x2 + 1, y2 + 1);
            } 
        } else if (y1 == y2) {
            if (x2 + 1 < N && graph[x2 + 1][y2] == 0) {
                dfs(x1 + 1, y1, x2 + 1, y2);
            }
            if (x2 + 1 < N && y2 + 1 < N && graph[x2 + 1][y2 + 1] == 0 && graph[x2 + 1][y2] == 0 && graph[x2][y2 + 1] == 0) {
                dfs(x1 + 1, y1, x2 + 1, y2 + 1);
            }
            
        } else {
            if (x2 + 1 < N && y2 + 1 < N && graph[x2 + 1][y2 + 1] == 0 && graph[x2 + 1][y2] == 0 && graph[x2][y2 + 1] == 0) {
                dfs(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
            }
            if (x2 + 1 < N && graph[x2 + 1][y2] == 0) {
                dfs(x1 + 1, y1 + 1, x2 + 1, y2);
            }
            if (y2 + 1 < N && graph[x2][y2 + 1] == 0) {
                dfs(x1 + 1, y1 + 1, x2, y2 + 1);
            }
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 1);

        System.out.println(result);

    }
}
