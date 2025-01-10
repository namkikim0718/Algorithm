import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static boolean dfs(int start, int now, List<Integer> cycle) {
        visited[now] = true;
        int next = arr[now];

        if (next == start) {
            answer.addAll(cycle);
            return true;
        }

        if (!visited[next]) {
            cycle.add(next);
            if (dfs(start, next, cycle)) {
                return true;
            }
        }

        visited[now] = false;
        return false;
    }

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            
            if (visited[i]) continue;

            List<Integer> cycle = new ArrayList<>();
            cycle.add(i);
            
            dfs(i, i, cycle);
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n");
        for (int each : answer) {
            sb.append(each + "\n");
        }
        System.out.println(sb.toString().trim());
    }
}