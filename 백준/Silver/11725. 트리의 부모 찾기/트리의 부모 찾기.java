import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parent;

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (visited[child]) continue;
            parent[child] = node;
            dfs(child, visited);
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        dfs(1, new boolean[N + 1]);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}