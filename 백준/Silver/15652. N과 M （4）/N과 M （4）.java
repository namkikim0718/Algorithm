import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int cnt, int[] myNums, int depth) {
        
        if (cnt == M) {
            for (int x : myNums) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = depth; i <= N; i++) {
            myNums[cnt] = i;
            dfs(cnt + 1, myNums, i);
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0, new int[M], 1);

        System.out.println(sb.toString().trim());
    }
}
