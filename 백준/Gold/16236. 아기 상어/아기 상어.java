import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph;
    static int nowSize = 2;
    static int fishEat = 0;
    static int time = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 거리 계산하는 함수
    static int[] findLocationWithDistance(int nowX, int nowY) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[2] == b[2]) { 
                    if (a[0] == b[0]) {
                        // x좌표 같으면 y좌표 비교
                        return Integer.compare(a[1], b[1]);
                    }
                    //거리 같으면 위에있는 순
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[2], b[2]);
            });

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{nowX, nowY, 0});
        visited[nowX][nowY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int nowDist = now[2];

            if (graph[x][y] > 0 && graph[x][y] < nowSize) {
                pq.offer(new int[]{x, y, nowDist});
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || graph[nx][ny] > nowSize) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, nowDist + 1});
            }
        }

        if (pq.isEmpty()) {
            return null;
        } else {
            return pq.poll();
        }
    }
    
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        int x = -1;
        int y = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    x = i;
                    y = j;
                    graph[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] target = findLocationWithDistance(x, y);

            if (target == null) break;

            // 자기 자신의 크기만큼 물고기 먹으면 크기 증가하고 먹은 물고기 개수 초기화
            fishEat++;
            if (fishEat == nowSize) {
                nowSize++;
                fishEat = 0;
            }
            
            x = target[0];
            y = target[1];
            graph[x][y] = 0;
            
            time += target[2];
        }

        System.out.println(time);
    }
}