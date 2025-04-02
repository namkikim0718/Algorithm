import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int totalCnt = 0;

    static void dfs(int a, int b, int cnt, int[] locations) {

        if (cnt == N) {
            totalCnt++;
            return;
        }


        for (int i = 0; i < N; i++) {
            if (isAvailable(locations, cnt, a, i)) {
                locations[a] = i;
                dfs(a + 1, i, cnt + 1, locations);
            }
        }
    }

    static boolean isAvailable(int[] locations, int cnt, int a, int b) {
        // 대각선
        for (int i = 0; i < cnt; i++) {
            int x = i;
            int y = locations[i];

            if (x == a || y == b || Math.abs(x - a) == Math.abs(y - b)) return false;
        }

        return true;
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        dfs(0, 0, 0, new int[N]);

        System.out.println(totalCnt);
    }
}
