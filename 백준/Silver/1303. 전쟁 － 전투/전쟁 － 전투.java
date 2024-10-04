import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[][] graphW;
    static int[][] graphB;
    static char[][] mainGraph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs(int a, int b, char color) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 1;

        if (color == 'W') graphW[a][b] = 1;
        else if (color == 'B') graphB[a][b] = 1;

        queue.offer(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (color == 'W') {
                        if (mainGraph[nx][ny] == 'W' && graphW[nx][ny] == 0) {
                            graphW[nx][ny] = 1;
                            cnt++;
                            queue.offer(new int[]{nx, ny});
                        }
                    } else if (color == 'B') {
                        if (mainGraph[nx][ny] == 'B' && graphB[nx][ny] == 0) {
                            graphB[nx][ny] = 1;
                            cnt++;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int wPower = 0;
        int bPower = 0;

        mainGraph = new char[M][N];
        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++) {
                mainGraph[i][j] = input.charAt(j);
            }
        }

        graphW = new int[M][N];
        graphB = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mainGraph[i][j] == 'W') {
                    if (graphW[i][j] == 0) {
                        int now = bfs(i, j, 'W');
                        wPower += now * now;
                    }
                } else if (mainGraph[i][j] == 'B') {
                    if (graphB[i][j] == 0) {
                        int now = bfs(i, j, 'B');
                        bPower += now * now;
                    }
                }
            }
        }

        System.out.println(wPower + " " + bPower);

    }
}