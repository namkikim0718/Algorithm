import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int E;
    static List<List<int[]>> graph = new ArrayList<>();

    static int dijkstra(int start, int end) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, 210_000_000);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] nowNode = pq.poll();
            int now = nowNode[0];
            int nowCost = nowNode[1];

            for (int[] edge : graph.get(now)) {
                int next = edge[0];
                int nextCost = edge[1];

                if (dist[now] < nowCost) continue;

                if (dist[next] > nowCost + nextCost) {
                    dist[next] = nowCost + nextCost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return dist[end];

    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, cost});
            graph.get(end).add(new int[]{start, cost});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int result = Math.min(result1, result2);
        if (result >= 210_000_000) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
}
