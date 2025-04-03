import java.util.*;
import java.io.*;

public class Main {

    static int V;
    static List<List<int[]>> graph = new ArrayList<>();
    static int maxDist = 0;
    static int mostFarNode = 0;
    static boolean[] visited;
    
    static void dfs(int now, int dist) {

        visited[now] = true;

        if (maxDist < dist) {
            maxDist = dist;
            mostFarNode = now;
        }

        for (int[] neighbor : graph.get(now)) {
            int next = neighbor[0];
            int cost = neighbor[1];
            if (!visited[next]) {
                dfs(next, dist + cost);
            }
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        V = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                graph.get(start).add(new int[]{end, cost});
                graph.get(end).add(new int[]{start, cost});
            }
        }

        visited = new boolean[V+1];
        dfs(1, 0);

        visited = new boolean[V+1];
        maxDist = 0;
        dfs(mostFarNode, 0);

        System.out.println(maxDist);
    }
}
