import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static char[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs(int[][] visited, int a, int b) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        visited[a][b] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 'L' && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int nowMaxDist = Integer.MIN_VALUE;
        for (int[] row : visited) {
            for (int x : row) {
                nowMaxDist = Math.max(nowMaxDist, x);
            }
        }

        return nowMaxDist;
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                graph[i][j] = input[j];
            }
        }

        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 'L') {
                    int[][] visited = new int[N][M];
                    for (int[] row : visited) {
                        Arrays.fill(row, -1);
                    }
                    maxDist = Math.max(maxDist, bfs(visited, i, j));
                }
            }
        }

        System.out.println(maxDist);

    }
}