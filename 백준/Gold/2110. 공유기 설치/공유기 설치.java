import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int C;
    static int[] homes;

    static int binarySearch() {
        int left = 1;
        int right = homes[N - 1] - homes[0];
        int maxDist = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            
            if (isAvailable(mid)) {
                maxDist = Math.max(maxDist, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxDist;
    }

    static boolean isAvailable(int minDist) {

        int cnt = 1;
        int lastHome = homes[0];

        for (int i = 1; i < N; i++) {
            if (homes[i] - lastHome >= minDist) {
                cnt++;
                lastHome = homes[i];
            }
        }

        return cnt >= C;
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        homes = new int[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        System.out.println(binarySearch());

    }
}