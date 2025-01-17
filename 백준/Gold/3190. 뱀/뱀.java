import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] graph;
    static int K;
    static int L;
    static Map<Integer, String> map = new HashMap<>();
    static int currentTime = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> snake = new ArrayList<>();
    static int nowDirection = 1;

    static void move(int x, int y) {
        // 상, 하, 좌, 우 방향별로 움직이는 것을 구현해야한다.
        // 꼬리가 위치한 칸을 비워주는 것을 해야하는데 메서드로 빼는게 좋을듯
        graph[x][y] = 1;
        snake.add(new int[]{x, y});

        while (true) {
            currentTime++;

            int nx = x + dx[nowDirection];
            int ny = y + dy[nowDirection];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 1) return;

            // 사과 없을 때 꼬리 지우기
            // 이 작업을 먼저 하지 않으면 꼬리를 만난 것도 몸에 부딪힌 것으로 처리되어 실패한다. .
            if (graph[nx][ny] != -1) {
                int[] tail = snake.remove(0);
                graph[tail[0]][tail[1]] = 0;
            }

            snake.add(new int[]{nx, ny});
            graph[nx][ny] = 1;
            x = nx;
            y = ny;

            // 방향 바꾸기
            if (map.containsKey(currentTime)) {
                if (map.get(currentTime).equals("D")) {
                    nowDirection = (nowDirection + 1) % 4;
                } else {
                    nowDirection = (nowDirection + 3) % 4;
                }
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        // 사과가 있는 곳은 -1로 표시
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x-1][y-1] = -1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            
            map.put(X, C);
        }

        move(0, 0);
        System.out.println(currentTime);
        
    }
}