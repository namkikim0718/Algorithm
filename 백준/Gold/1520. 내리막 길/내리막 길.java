import java.util.*;
import java.io.*;

public class Main {

    static int M;
    static int N;
    static int[][] graph;
    static int[][] visited;
    static int cnt = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int dfs(int x, int y) {

        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (visited[x][y] != -1) {
            return visited[x][y];
        }

        visited[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || graph[x][y] <= graph[nx][ny]) continue;

            visited[x][y] += dfs(nx, ny);
        }
        
        return visited[x][y];
    }

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new int[M][N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }

        
        dfs(0, 0);
        System.out.println(visited[0][0]);
    }
}