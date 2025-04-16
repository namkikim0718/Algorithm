import java.util.*;
import java.io.*;

public class Main {

    static int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }

        return parent[node];
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        int[] parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int cnt = 0;
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int parentFrom = findParent(parent, from);
            int parentTo = findParent(parent, to);
            if (parentFrom != parentTo) {
                parent[parentTo] = parentFrom;
                totalCost += cost;
                cnt++;
            }

            if (cnt == E - 1) break;
        }

        System.out.println(totalCost);

    }
}
