import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] trees = new long[N];

        long left = 1;
        long right = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        long answer = 0;

        while (left <= right) {
            long myTree = 0;
            long mid = (left + right) / 2;

            for (long tree : trees) {
                if (mid < tree) {
                    myTree += tree - mid;
                }
            }

            if (myTree >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
