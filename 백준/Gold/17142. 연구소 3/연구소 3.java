import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> twoLists = new ArrayList<>();
    static List<List<int[]>> virusLocations = new ArrayList<>();
    static int spaceCnt = 0;

    // 2인 좌표 중 M개를 큐에 넣어두고 bfs돌리면 될듯
    // 벽은 -1로 설정해보자
    // 바이러스를 놓는 경우의 수는 최악의 경우 10C5 = 252정도
    // 모든 경우의 수를 2차원 ArrayList로 저장 후 각각 뽑아서 bfs를 돌리고
    // 전체가 0인 지점이 없도록 하면 될 것으로 예상된다.

    static int bfs(List<int[]> locations) {
        Queue<int[]> queue = new LinkedList<>();
        int maxTime = 0;
        int nowCnt = 0;
        int[][] time = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(time[i], -1);
        }

        for (int[] location : locations) {
            queue.offer(location);
            int x = location[0];
            int y = location[1];
            time[x][y] = 0;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] == 1 || time[nx][ny] != -1) continue;

                if (graph[nx][ny] == 0) {
                    time[nx][ny] = time[x][y] + 1;
                    nowCnt++;
                    maxTime = Math.max(time[nx][ny], maxTime);
                } else if (graph[nx][ny] == 2) {
                    time[nx][ny] = time[x][y] + 1;
                }
                
                queue.offer(new int[]{nx, ny});
            }
        }

        if (nowCnt == spaceCnt) {
            return maxTime;
        } else {
            return -1;
        }
    }

    static void findCombinations(List<int[]> locations, int beforeIdx) {
        if (locations.size() == M) {
            virusLocations.add(new ArrayList<>(locations));
            return;
        }

        for (int i = beforeIdx; i < twoLists.size(); i++) {
            locations.add(twoLists.get(i));
            findCombinations(locations, i+1);
            locations.remove(locations.size() - 1);
        }

    }
    
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 2) {
                    twoLists.add(new int[]{i, j});
                } else if(now == 0)  {
                    spaceCnt++;
                }
                graph[i][j] = now;
            }
        }

        findCombinations(new ArrayList<>(), 0);


        int answer = Integer.MAX_VALUE;
        for (List<int[]> virusLocation : virusLocations) {
            int result = bfs(virusLocation);
            if (result != -1) {
                answer = Math.min(answer, result);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}