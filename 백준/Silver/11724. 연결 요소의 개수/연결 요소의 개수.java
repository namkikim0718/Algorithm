import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        for (int x : graph.get(node)) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        System.out.println(answer);
    }
}
