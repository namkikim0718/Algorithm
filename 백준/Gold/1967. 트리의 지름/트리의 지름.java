import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<List<int[]>> graph = new ArrayList<>();
    static int maxDist = Integer.MIN_VALUE;

    static void dfs(int start, int totalDist, boolean[] visited) {

        maxDist = Math.max(totalDist, maxDist);

        for (int[] node : graph.get(start)) {
            int end = node[0];
            int cost = node[1];

            if (!visited[end]) {
                visited[end] = true;
                dfs(end, totalDist + cost, visited);
                visited[end] = false;
            }
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, cost});
            graph.get(end).add(new int[]{start, cost});
        }

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0, visited);
        }

        System.out.println(maxDist);
    }
}
