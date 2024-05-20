import java.util.*;

public class Main {

    public static String Solution(int[] home, int[][] stores, int[] dest, Boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(home);
        while (!queue.isEmpty()) {
            int[] nLoc = queue.poll();
            if (Math.abs(dest[0] - nLoc[0]) + Math.abs(dest[1] - nLoc[1]) <= 1000) {
                return "happy";
            }
            
            for (int i = 0; i < stores.length; i++) {
                int[] store = stores[i];
                if (Math.abs(store[0] - nLoc[0]) + Math.abs(store[1] - nLoc[1]) <= 1000 && !visited[i]) {
                    queue.offer(store);
                    visited[i] = true;
                }
            }
        } 
        return "sad";

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int t = kb.nextInt();
        for (int i = 0; i < t; i++) {
            int storeCnt = kb.nextInt();
            int[] home = new int[2];
            home[0] = kb.nextInt();
            home[1] = kb.nextInt();
            int[][] stores = new int[storeCnt][2];
            Boolean[] visited = new Boolean[storeCnt];
            for (int k = 0; k < storeCnt; k++) {
                stores[k][0] = kb.nextInt();
                stores[k][1] = kb.nextInt();
                visited[k] = false;
            }
            
            int[] dest = new int[2];
            dest[0] = kb.nextInt();
            dest[1] = kb.nextInt();

            System.out.println(Solution(home, stores, dest, visited));
        }
    }
}