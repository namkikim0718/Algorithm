import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[][] originalGraph;
    static int[][] resultGraph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int a, int b) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && resultGraph[nx][ny] == 0 && originalGraph[nx][ny] == 1) {
                    resultGraph[nx][ny] = resultGraph[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (resultGraph[i][j] == 0 && originalGraph[i][j] == 1) {
                    resultGraph[i][j] = -1;
                }
            }
        }

    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        originalGraph = new int[n][m];
        resultGraph = new int[n][m];
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalGraph[i][j] = Integer.parseInt(st.nextToken());
                if (originalGraph[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(resultGraph[i][j] + " ");
            }
            sb.append("\n");
        }
        

        System.out.println(sb.toString().trim());

    }
}