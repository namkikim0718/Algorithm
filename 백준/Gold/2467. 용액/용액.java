import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] liquid = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        
        long minValue = Long.MAX_VALUE;
        long[] result = new long[2];
        while (left < right) {
            long value = Math.abs(liquid[left] + liquid[right]);

            if (minValue > value) {
                minValue = value;

                result[0] = liquid[left];
                result[1] = liquid[right];
            }

            if (liquid[right] + liquid[left] >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}