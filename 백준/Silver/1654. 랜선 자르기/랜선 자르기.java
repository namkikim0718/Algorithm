import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        int maxLine = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            maxLine = Math.max(maxLine, lines[i]);
        }

        long left = 1;
        long right = maxLine;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long availableCnt = 0;
            for (int line : lines) {
                availableCnt += line / mid;
            }

            if (availableCnt >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}