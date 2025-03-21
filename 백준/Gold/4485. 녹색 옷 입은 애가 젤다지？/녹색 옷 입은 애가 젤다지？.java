import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dijkstra(int a, int b) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        dist[0][0] = graph[0][0];
        pq.offer(new int[]{0, 0, graph[0][0]});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newDist = dist[x][y] + graph[nx][ny];

                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        pq.offer(new int[]{nx, ny, graph[nx][ny]});
                    }
                }
            }
        }

        
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int idx = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            graph = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra(0, 0);
            sb.append("Problem " + idx + ": " + dist[N-1][N-1] + "\n");

            idx++;
        }

        System.out.println(sb.toString().trim());

    }
}