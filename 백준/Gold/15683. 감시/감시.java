import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static List<int[]> cctvs = new ArrayList<>();
    static int minCnt = 0;

    static int[][] copyGraph(int[][] graph) {
        int[][] newGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(graph[i], 0, newGraph[i], 0, M);
        }
        return newGraph;
    }

    static int countBlind(int[][] graph) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static void checkRoot(int depth, int[][] graph) {
        if (depth >= cctvs.size()) {
            minCnt = Math.min(minCnt, countBlind(graph));
            return;
        }

        int[] now = cctvs.get(depth);
        int x = now[0];
        int y = now[1];
        int nx = x;
        int ny = y;

        if (graph[x][y] == 1) {
            // up
            int[][] newGraph0 = copyGraph(graph);
            nx = x;
            while (nx >= 0) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx--;
            }
            checkRoot(depth+1, newGraph0);

            // right
            int[][] newGraph1 = copyGraph(graph);
            ny = y;
            while (ny < M) {
                if (newGraph1[x][ny] == 6) break;
                if (newGraph1[x][ny] == 0) {
                    newGraph1[x][ny] = -1;
                }
                ny++;
            }
            checkRoot(depth+1, newGraph1);

            //down
            int[][] newGraph2 = copyGraph(graph);
            nx = x;
            while (nx < N) {
                if (newGraph2[nx][y] == 6) break;
                if (newGraph2[nx][y] == 0) {
                    newGraph2[nx][y] = -1;
                }
                nx++;
            }
            checkRoot(depth+1, newGraph2);
            
            // left
            int[][] newGraph3 = copyGraph(graph);
            ny = y;
            while (ny >= 0) {
                if (newGraph3[x][ny] == 6) break;
                if (newGraph3[x][ny] == 0) {
                    newGraph3[x][ny] = -1;
                }
                ny--;
            }
            checkRoot(depth+1, newGraph3);

        } else if (graph[x][y] == 2) {
            // up-down
            int[][] newGraph0 = copyGraph(graph);
            nx = x;
            while (nx >= 0) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx--;
            }

            nx = x;
            while (nx < N) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx++;
            }
            checkRoot(depth+1, newGraph0);

            // left-right
            int[][] newGraph1 = copyGraph(graph);
            ny = y;
            while (ny >= 0) {
                if (newGraph1[x][ny] == 6) break;
                if (newGraph1[x][ny] == 0) {
                    newGraph1[x][ny] = -1;
                }
                ny--;
            }

            ny = y;
            while (ny < M) {
                if (newGraph1[x][ny] == 6) break;
                if (newGraph1[x][ny] == 0) {
                    newGraph1[x][ny] = -1;
                }
                ny++;
            }
            checkRoot(depth+1, newGraph1);

        } else if (graph[x][y] == 3) {
            // up-right
            int[][] newGraph0 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx >= 0) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx--;
            }
            while (ny < M) {
                if (newGraph0[x][ny] == 6) break;
                if (newGraph0[x][ny] == 0) {
                    newGraph0[x][ny] = -1;
                }
                ny++;
            }
            checkRoot(depth+1, newGraph0);

            // right-down
            int[][] newGraph1 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx < N) {
                if (newGraph1[nx][y] == 6) break;
                if (newGraph1[nx][y] == 0) {
                    newGraph1[nx][y] = -1;
                }
                nx++;
            }
            while (ny < M) {
                if (newGraph1[x][ny] == 6) break;
                if (newGraph1[x][ny] == 0) {
                    newGraph1[x][ny] = -1;
                }
                ny++;
            }
            checkRoot(depth+1, newGraph1);

            // down-left
            int[][] newGraph2 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx < N) {
                if (newGraph2[nx][y] == 6) break;
                if (newGraph2[nx][y] == 0) {
                    newGraph2[nx][y] = -1;
                }
                nx++;
            }
            while (ny >= 0) {
                if (newGraph2[x][ny] == 6) break;
                if (newGraph2[x][ny] == 0) {
                    newGraph2[x][ny] = -1;
                }
                ny--;
            }
            checkRoot(depth+1, newGraph2);

            // left-up
            int[][] newGraph3 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx >= 0) {
                if (newGraph3[nx][y] == 6) break;
                if (newGraph3[nx][y] == 0) {
                    newGraph3[nx][y] = -1;
                }
                nx--;
            }
            while (ny >= 0) {
                if (newGraph3[x][ny] == 6) break;
                if (newGraph3[x][ny] == 0) {
                    newGraph3[x][ny] = -1;
                }
                ny--;
            }
            checkRoot(depth+1, newGraph3);

        } else if (graph[x][y] == 4) {

            // up-right-down
            int[][] newGraph0 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx >= 0) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx--;
            }
            while (ny < M) {
                if (newGraph0[x][ny] == 6) break;
                if (newGraph0[x][ny] == 0) {
                    newGraph0[x][ny] = -1;
                }
                ny++;
            }
            nx = x;
            while (nx < N) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx++;
            }
            checkRoot(depth+1, newGraph0);

            // right-down-left
            int[][] newGraph1 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx < N) {
                if (newGraph1[nx][y] == 6) break;
                if (newGraph1[nx][y] == 0) {
                    newGraph1[nx][y] = -1;
                }
                nx++;
            }
            while (ny < M) {
                if (newGraph1[x][ny] == 6) break;
                if (newGraph1[x][ny] == 0) {
                    newGraph1[x][ny] = -1;
                }
                ny++;
            }
            ny = y;
            while (ny >= 0) {
                if (newGraph1[x][ny] == 6) break;
                if (newGraph1[x][ny] == 0) {
                    newGraph1[x][ny] = -1;
                }
                ny--;
            }
            checkRoot(depth+1, newGraph1);

            // down-left-up
            int[][] newGraph2 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx >= 0) {
                if (newGraph2[nx][y] == 6) break;
                if (newGraph2[nx][y] == 0) {
                    newGraph2[nx][y] = -1;
                }
                nx--;
            }
            while (ny >= 0) {
                if (newGraph2[x][ny] == 6) break;
                if (newGraph2[x][ny] == 0) {
                    newGraph2[x][ny] = -1;
                }
                ny--;
            }
            nx = x;
            while (nx < N) {
                if (newGraph2[nx][y] == 6) break;
                if (newGraph2[nx][y] == 0) {
                    newGraph2[nx][y] = -1;
                }
                nx++;
            }
            checkRoot(depth+1, newGraph2);

            // left-up-right
            int[][] newGraph3 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx >= 0) {
                if (newGraph3[nx][y] == 6) break;
                if (newGraph3[nx][y] == 0) {
                    newGraph3[nx][y] = -1;
                }
                nx--;
            }
            while (ny < M) {
                if (newGraph3[x][ny] == 6) break;
                if (newGraph3[x][ny] == 0) {
                    newGraph3[x][ny] = -1;
                }
                ny++;
            }
            ny = y;
            while (ny >= 0) {
                if (newGraph3[x][ny] == 6) break;
                if (newGraph3[x][ny] == 0) {
                    newGraph3[x][ny] = -1;
                }
                ny--;
            }
            checkRoot(depth+1, newGraph3);

        } else if (graph[x][y] == 5) {

            int[][] newGraph0 = copyGraph(graph);
            nx = x;
            ny = y;
            while (nx >= 0) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx--;
            }
            while (ny < M) {
                if (newGraph0[x][ny] == 6) break;
                if (newGraph0[x][ny] == 0) {
                    newGraph0[x][ny] = -1;
                }
                ny++;
            }
            nx = x;
            while (nx < N) {
                if (newGraph0[nx][y] == 6) break;
                if (newGraph0[nx][y] == 0) {
                    newGraph0[nx][y] = -1;
                }
                nx++;
            }
            ny = y;
            while (ny >= 0) {
                if (newGraph0[x][ny] == 6) break;
                if (newGraph0[x][ny] == 0) {
                    newGraph0[x][ny] = -1;
                }
                ny--;
            }
            checkRoot(depth+1, newGraph0);
        }
        

    }

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                graph[i][j] = now;
                if (now != 0 && now != 6) {
                    cctvs.add(new int[]{i, j});    
                }
                if (now == 0) {
                    minCnt++;
                }
            }    
        }

        checkRoot(0, graph);

        System.out.println(minCnt);
    }
}