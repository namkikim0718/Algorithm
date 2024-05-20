import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[][] graph;
    public static int[][] airGraph;
    public static Boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static Boolean isAllMelt = false;
    public static int time = 0;
    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void Solution() {
        int lastCnt = 0;

        while (!isAllMelt) {
            lastCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 0; i < N; i++) {
                if (graph[i][0] == 0 && !visited[i][0]) {
                    bfs(i, 0);
                }
                if (graph[i][M-1] == 0 && !visited[i][M-1]) {
                    bfs(i, M-1);
                }
            }
            for (int j = 0; j < M; j++) {
                if (graph[0][j] == 0 && !visited[0][j]) {
                    bfs(0, j);
                }
                if (graph[N-1][j] == 0 && !visited[N-1][j]) {
                    bfs(N-1, j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) {
                        Boolean isContact = false;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (airGraph[nx][ny] == 1) {
                                isContact = true;
                            }
                        }
                        if (isContact) {
                            graph[i][j] = 0;
                            lastCnt++;
                        }
                    }
                }
            }
            
            isAllMelt = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) {
                        isAllMelt = false;
                        break;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
        System.out.println(lastCnt);
        
    }

    public static void bfs(int a, int b) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a, b));
        visited[a][b] = true;
        airGraph[a][b] = 1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    airGraph[nx][ny] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        M = kb.nextInt();
        graph = new int[N][M];
        airGraph = new int[N][M];
        visited = new Boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = kb.nextInt();
                airGraph[i][j] = 0;
                visited[i][j] = false;
            }
        }

        Solution();
    }
}
