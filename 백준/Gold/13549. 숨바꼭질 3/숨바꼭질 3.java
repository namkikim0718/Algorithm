import java.util.*;
import java.io.*;

public class Main {

    static int[] visited = new int[100_001];

    static void bfs(int N, int K) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) return;

            if (now * 2 <= 100_000 && visited[now * 2] == -1) {
                visited[now * 2] = visited[now];
                queue.offer(now * 2);
            }

            if (now - 1 >= 0 && visited[now - 1] == -1) {
                visited[now - 1] = visited[now] + 1;
                queue.offer(now - 1);
            }

            if (now + 1 <= 100_000 && visited[now + 1] == -1) {
                visited[now + 1] = visited[now] + 1;
                queue.offer(now + 1);
            }
        }

    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(visited, -1);

        bfs(N, K);

        System.out.println(visited[K]);
    }
}