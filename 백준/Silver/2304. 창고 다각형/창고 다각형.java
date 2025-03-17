import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] towers = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            towers[i][0] = Integer.parseInt(st.nextToken());
            towers[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(towers, (a, b) -> {
            return a[0] - b[0];
        });

        int maxHeight = 0;
        int mostHighIdx = -1;
        for (int i = 0; i < N; i++) {
            if (towers[i][1] > maxHeight) {
                maxHeight = towers[i][1];
                mostHighIdx = i;
            }
        }

        int total = 0;

        int startX = towers[0][0];
        int nowHeight = towers[0][1];

        for (int i = startX; i <= towers[mostHighIdx][0]; i++) {
            int nowY = -1;
            for (int[] tower : towers) {
                if (tower[0] == i) {
                    nowY = tower[1];
                    break;
                }
            }
            
            if (nowY > nowHeight) {
                nowHeight = nowY;
            }

            total += nowHeight;
        }

        int endX = towers[N - 1][0];
        nowHeight = towers[N - 1][1];
        for (int i = endX; i > towers[mostHighIdx][0]; i--) {
            int nowY = -1;
            for (int[] tower : towers) {
                if (tower[0] == i) {
                    nowY = tower[1];
                    break;
                }
            }

            if (nowY > nowHeight) {
                nowHeight = nowY;
            }

            total += nowHeight;
        }


        System.out.println(total);
    }
}