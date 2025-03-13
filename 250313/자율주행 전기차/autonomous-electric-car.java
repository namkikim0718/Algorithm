import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int c;
    static int[][] graph;
    static int[][] passengers;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] visited;

    static int[] pickPassenger(int startX, int startY) {
        int minDist = Integer.MAX_VALUE;
        int[][] newGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        newGraph[startX][startY] = 1;

        // bfs로 탐색해서 찾자.
        while (!queue.isEmpty()) {
            int[] nowLoc = queue.poll();
            int x = nowLoc[0];
            int y = nowLoc[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && newGraph[nx][ny] == 0) {
                    newGraph[nx][ny] = newGraph[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (visited[i]) continue;
            int passengerX = passengers[i][0];
            int passengerY = passengers[i][1];

            if (newGraph[passengerX][passengerY] == 0) continue;
            minDist = Math.min(minDist, newGraph[passengerX][passengerY]);
        }

        if (minDist == Integer.MAX_VALUE) return new int[]{-1, -1};

        // 가장 가까운 손님 리스트 뽑기
        List<Integer> closePassenger = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (visited[i]) continue;
            int passengerX = passengers[i][0];
            int passengerY = passengers[i][1];
    
            if (minDist == newGraph[passengerX][passengerY]) {
                closePassenger.add(i);
            }
        }

        if (closePassenger.isEmpty()) return new int[]{-1, -1};

        Collections.sort(closePassenger, (a, b) -> {
            if (passengers[a][0] == passengers[b][0]) {
                return passengers[a][1] - passengers[b][1];
            }
            return passengers[a][0] - passengers[b][0];
        });

        return new int[]{closePassenger.get(0), minDist - 1};
    }

    // 승객을 탑승위치부터 목적지까지 이동하는 메서드
    static boolean move(int passengerIdx) {
        int startX = passengers[passengerIdx][0];
        int startY = passengers[passengerIdx][1];
        int endX = passengers[passengerIdx][2];
        int endY = passengers[passengerIdx][3];

        int[][] newGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        newGraph[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] nowLoc = queue.poll();
            int x = nowLoc[0];
            int y = nowLoc[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && newGraph[nx][ny] == 0) {
                    newGraph[nx][ny] = newGraph[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        if (newGraph[endX][endY] == 0) return false;
        if (c < newGraph[endX][endY] - 1) return false;
        
        c += newGraph[endX][endY] - 1;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        passengers = new int[m][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    graph[i][j] = -1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                passengers[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        visited = new boolean[m];
        while (true) {
            boolean isDone = true;
            for (int i = 0; i < m; i++) {
                if (!visited[i]) {
                    isDone = false;
                    break;
                }
            }

            if (isDone) break;

            int[] closePassengerInfo = pickPassenger(startX, startY);
            int passengerIdx = closePassengerInfo[0];
            int minDist = closePassengerInfo[1];

            if (passengerIdx == -1 || c < minDist) {
                System.out.println(-1);
                return;
            }
            c -= minDist;
            if (!move(passengerIdx)) {
                System.out.println(-1);
                return;
            }

            // 시작위치 초기화
            startX = passengers[passengerIdx][2];
            startY = passengers[passengerIdx][3];
            visited[passengerIdx] = true;
        }

        System.out.println(c);
    }
}