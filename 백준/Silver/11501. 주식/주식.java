import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] days = new int[N];
            for (int i = 0; i < N; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            int maxDay = 0;
            long profit = 0;
            for (int i = N - 1; i >= 0 ; i--) {
                
                if (days[i] > maxDay) {
                    maxDay = days[i];
                } else {
                    profit += maxDay - days[i];
                }
            }

            sb.append(profit).append("\n");

        }

        System.out.println(sb.toString().trim());

    }
}
