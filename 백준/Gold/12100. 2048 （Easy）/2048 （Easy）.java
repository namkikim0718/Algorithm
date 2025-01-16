import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] originGraph;
    static int maxValue = Integer.MIN_VALUE;

    static void dfs(int direction, int depth, int[][] graph) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxValue = Math.max(maxValue, graph[i][j]);
                }
            }
            return;
        }
        // 상, 하, 좌, 우 각 경우마다 움직이는 로직을 만들어야하는데. .
        // 좌, 우로 움직이는거는 가로로 각 배열을 따로 만들어서 보내줘서 로직 수행하도록.
        // 상, 하로 움직이는거는 세로로 각 배열을 따로 만들어서 보내줘서 . .

        // 상
        if (direction == 0) {
            for (int j = 0; j < N; j++) {
                int[] list = new int[N];
                for (int i = 0; i < N; i++) {
                    list[i] = graph[i][j];
                }
                // 한줄씩 움직이기
                int[] result = move(list);
                
                // 결과를 실제 배열에 적용
                for (int i = 0; i < N; i++) {
                    graph[i][j] = result[i];
                }
            }
        } else if (direction == 1) { // 하
            for (int j = 0; j < N; j++) {
                int[] list = new int[N];
                for (int i = 0; i < N; i++) {
                    list[i] = graph[N-i-1][j];
                }
                // 한줄씩 움직이기
                int[] result = move(list);
                // 결과를 실제 배열에 적용
                for (int i = 0; i < N; i++) {
                    graph[N-i-1][j] = result[i];
                }
            }
        } else if (direction == 2) { // 좌
            for (int i = 0; i < N; i++) {
                int[] list = new int[N];
                for (int j = 0; j < N; j++) {
                    list[j] = graph[i][j];
                }
                // 한줄씩 움직이기
                int[] result = move(list);
                // 결과를 실제 배열에 적용
                for (int j = 0; j < N; j++) {
                    graph[i][j] = result[j];
                }
            } 
        } else if (direction == 3) { // 우
            for (int i = 0; i < N; i++) {
                int[] list = new int[N];
                for (int j = 0; j < N; j++) {
                    list[j] = graph[i][N-j-1];
                }
                // 한줄씩 움직이기
                int[] result = move(list);
                // 결과를 실제 배열에 적용
                for (int j = 0; j < N; j++) {
                    graph[i][N-j-1] = result[j];
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int[][] copiedGraph = new int[N][N];
            for (int j = 0; j < N; j++) {
                System.arraycopy(graph[j], 0, copiedGraph[j], 0, N);
            }
            dfs(i, depth+1, copiedGraph);
        }
    }

    static int[] move(int[] list) {
        
        int[] result = new int[N];
        boolean merged = false;

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (list[i] == 0) continue; // 빈칸 무시
            if (idx > 0 && result[idx-1] == list[i] && !merged) {
                result[idx-1] *= 2;
                merged = true;
            } else {
                result[idx++] = list[i];
                merged = false;
            }
        }


        return result;
    }
    
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        originGraph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                originGraph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상하좌우 총 5^4번 해서 가장 큰값 찾아내면된다.
        // 재귀를 통해서 타고 들어가는게 가장 간단한 방법일듯?
        // originGraph를 복사한 배열 graph로 탐색        
        for (int k = 0; k < 4; k++) {
            int[][] copiedGraph = new int[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(originGraph[i], 0, copiedGraph[i], 0, N);
            }    
            dfs(k, 0, copiedGraph);
        }

        System.out.println(maxValue);
        
    }
}