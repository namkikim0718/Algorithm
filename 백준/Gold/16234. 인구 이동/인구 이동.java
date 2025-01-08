import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };
    static int[][] graph;
    static boolean[][] visited;

    public static boolean bfs(int i, int j) {
        
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new LinkedList<>();

        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        union.add(new int[]{i, j});
        int sum = graph[i][j];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
                    

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= N || ny >= N || nx < 0 || ny < 0) continue;
                int dist = Math.abs(graph[nx][ny] - graph[x][y]);
                if (dist >= L && dist <= R && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += graph[nx][ny];
                }
            }
        }

        if (union.size() == 1) return false;

        int newNum = sum / union.size();
        for (int k = 0; k < union.size(); k++) {
            int[] now = union.get(k);
            int a = now[0];
            int b = now[1];

            graph[a][b] = newNum;
        }

        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs로 순회하면서 열려있는 칸 true로 표시
        // true로 되어있는 칸들 전부다 합해서 개수로 나눈 값으로 변경. But, 구역이 여러개로 나눠지면 어떻게 할것인가?
        // i, j 로 돌리는데 각 i, j 마다 한번씩 계산을 해서 값을 변경한다면, 조건에 해당하지 않으면 바로 다음거로 넘어가니까 괜찮을 것으로 예상.
        int changeDays = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean nothingOpen = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            nothingOpen = false;
                        }
                    }
                    
                }
            }

            if (nothingOpen) break;
            
            changeDays++;
        }

        System.out.println(changeDays);
    }
}