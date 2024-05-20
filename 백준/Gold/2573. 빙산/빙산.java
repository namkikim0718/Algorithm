import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[][] graph;
    public static int[][] zeroGraph;
    public static Boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int answer = 0;
    public static int sectionCnt = 0;

    public static int Solution() {
        while (sectionCnt < 2) {

            Boolean isAllZero = true;
            sectionCnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visited[i][j] = false;
                    int zeroCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
                            zeroCnt++;
                        }
                    }
                    zeroGraph[i][j] = zeroCnt;
                    if (graph[i][j] != 0) {
                        isAllZero = false;
                    }
                }
            }

            if (isAllZero) {
                return 0;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] > zeroGraph[i][j]) {
                        graph[i][j] -= zeroGraph[i][j];
                    } else {
                        graph[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        sectionCnt++;
                    }
                }
            }
            answer++;
        }

        if (sectionCnt >= 2) {
            return answer;
        } else {
            return 0;
        }
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] != 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        M = kb.nextInt();

        graph = new int[N][M];
        zeroGraph = new int[N][M];
        visited = new Boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = kb.nextInt();
                zeroGraph[i][j] = 0;
            }
        }

        System.out.println(Solution());
    }
}