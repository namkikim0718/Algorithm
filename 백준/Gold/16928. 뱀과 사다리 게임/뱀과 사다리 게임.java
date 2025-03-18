import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static Map<Integer, Integer> ladderMap = new HashMap<>();
    static Map<Integer, Integer> snakeMap = new HashMap<>();
    static int[] visited = new int[101];

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (ladderMap.containsKey(now)) {
                int next = ladderMap.get(now);
                visited[next] = visited[now];
                now = next;
            }

            if (snakeMap.containsKey(now)) {
                int next = snakeMap.get(now);
                visited[next] = visited[now];
                now = next;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next <= 100 && visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
        
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladderMap.put(start, end);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snakeMap.put(start, end);
        }

        bfs();

        System.out.println(visited[100]);

    }
}