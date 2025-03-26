import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        long answer = Long.MAX_VALUE;
        for (int i = 1; i < (1 << N); i++) {
            long multiple = 1;
            long sum = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    multiple *= arr[j][0];
                    sum += arr[j][1];
                }
            }

            answer = Math.min(answer, Math.abs(multiple - sum));
        }

        System.out.println(answer);
    }
}