import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int L;
    static int[][] graph;

    static boolean checkPath(int[] path) {
        boolean[] isUsed = new boolean[N];

        for (int i = 1; i < N; i++) {
            if (Math.abs(path[i] - path[i-1]) == 0) continue;

            if (Math.abs(path[i] - path[i-1]) > 1) {
                return false;
            }

            // 높아질 때
            if (path[i] > path[i-1]) {
                for (int j = 0; j < L; j++) {
                    int preIdx = i - j - 1;
                    if (preIdx < 0 || path[preIdx] != path[i - 1] || isUsed[preIdx]) {
                        return false;
                    }
                    isUsed[preIdx] = true;
                }
            }

            //낮아질 때
            if (path[i] < path[i-1]) {
                for (int j = 0; j < L; j++) {
                    int nextIdx = i + j;
                    if (nextIdx >= N || path[nextIdx] != path[i] || isUsed[nextIdx]) {
                        return false;
                    }
                    isUsed[nextIdx] = true;
                }
            }
        }
        return true;
        
    }

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        // 가로
        for (int i = 0; i < N; i++) {
            if (checkPath(graph[i])) {
                answer++;
            }
        }

        // 세로
        for (int j = 0; j < N; j++) {
            int[] path = new int[N];
            for (int i = 0; i < N; i++) {
                path[i] = graph[i][j];
            }
            if (checkPath(path)) {
                answer++;
            }
        }

        

        System.out.println(answer);
    }
}