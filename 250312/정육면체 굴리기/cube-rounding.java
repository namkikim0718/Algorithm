import java.util.*;
import java.io.*;

public class Main {

    
    static int n;
    static int m;
    static int x;
    static int y;
    static int k;
    static int[][] map;
    static int[] commands;
    // 위, 아래, 왼, 오, 앞, 뒤
    static int[] dice = {0, 0, 0, 0, 0, 0};

    static String rollDice() {
        StringBuilder sb = new StringBuilder();
        for (int command : commands) {
            
            int[] newDice = new int[6];
            for (int i = 0; i < 6; i++) {
                newDice[i] = dice[i];
            }

            // 동쪽
            if (command == 1) {
                if (y + 1 >= m) continue;
                dice[0] = newDice[2];
                dice[1] = newDice[3];
                dice[2] = newDice[1];
                dice[3] = newDice[0];
                
                y++;
            } else if (command == 2) {
                if (y - 1 < 0) continue;

                dice[0] = newDice[3];
                dice[1] = newDice[2];
                dice[2] = newDice[0];
                dice[3] = newDice[1];
                y--;
            } else if (command == 3) {
                if (x - 1 < 0) continue;

                dice[0] = newDice[4];
                dice[1] = newDice[5];
                dice[4] = newDice[1];
                dice[5] = newDice[0];
                x--;
            } else {
                if (x + 1 >= n) continue;

                dice[0] = newDice[5];
                dice[1] = newDice[4];
                dice[4] = newDice[0];
                dice[5] = newDice[1];
                x++;
            }

            if (map[x][y] == 0) {
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[0] + "\n");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        commands = new int[k];
        for (int i = 0; i < k; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(rollDice());
    }
}