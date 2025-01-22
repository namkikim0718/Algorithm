import java.util.*;
import java.io.*;

public class Main {

    static int[][] graph = new int[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static void dragon(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        // 0세대부터 맨 뒤에꺼부터 반시계방향으로 돌려서 움직여야함..!
        for (int i = 0; i < g; i++) {
            for (int j = directions.size() - 1; j >= 0; j--) {
                directions.add((directions.get(j) + 1) % 4);
            }
        }

        graph[x][y] = 1;
        for (int direction : directions) {
            x += dx[direction];
            y += dy[direction];
            graph[x][y] = 1;
        }
        
    }
    
    public static void main(String args[]) throws IOException {
        // 시작 방향과 시작점을 입력받아 각 세대별로 이동하는 메서드를 만들자.
        // 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragon(x, y, d, g);
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (graph[i][j] == 0 || graph[i][j+1] == 0 || graph[i+1][j] == 0 || graph[i+1][j+1] == 0) {
                    continue;
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}