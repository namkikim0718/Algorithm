import java.util.*;
import java.io.*;

public class Main {

    static int[][] gear = new int[4][8];
    static int K;
    static int[][] rotate;


    static void move(int direction, int gearIndex) {

        if (direction == 1) {
            int temp = gear[gearIndex][7];
            for (int i = 7; i > 0; i--) {
                gear[gearIndex][i] = gear[gearIndex][i-1];
            }
            gear[gearIndex][0] = temp;
        } else {
            int temp = gear[gearIndex][0];
            for (int i = 0; i < 7; i++) {
                gear[gearIndex][i] = gear[gearIndex][i+1];
            }
            gear[gearIndex][7] = temp;
        }
        
    }

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        K = Integer.parseInt(br.readLine());
        rotate = new int[K][2];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotate[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rotate[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] x : rotate) {
            int targetGear = x[0];
            int direction = x[1];

            int[] beforeLeft = new int[4];
            int[] beforeRight = new int[4];
            for (int i = 0; i < 4; i++) {
                beforeLeft[i] = gear[i][6];
                beforeRight[i] = gear[i][2];
            }


            move(direction, targetGear);

            int nowGear = targetGear + 1;
            int nowDirection = direction;
            while (nowGear < 4) {
                if (beforeLeft[nowGear] == beforeRight[nowGear - 1]) break;
                nowDirection *= -1;
                move(nowDirection, nowGear);
                nowGear++;
            }

            nowGear = targetGear - 1;
            nowDirection = direction;
            while (nowGear >= 0) {
                if (beforeRight[nowGear] == beforeLeft[nowGear + 1]) break;
                nowDirection *= -1;
                move(nowDirection, nowGear);
                nowGear--;
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) {
                score += Math.pow(2, i);
            }
        }

        System.out.println(score);
    }
}