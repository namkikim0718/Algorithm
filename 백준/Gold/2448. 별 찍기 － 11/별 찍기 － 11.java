import java.util.*;
import java.io.*;

public class Main {

    static char[][] myStars;

    static void stars(int x, int y, int size) {

        int half = size / 2;

        if (size == 3) {
            myStars[x][y] = '*';
            myStars[x+1][y-1] = '*';
            myStars[x+1][y+1] = '*';
            for (int i = y - 2; i <= y + 2; i++) {
                myStars[x+2][i] = '*';
            }

            return;
        }

        stars(x, y, half);
        stars(x+half, y-half, half);
        stars(x+half, y+half, half);
        
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        myStars = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(myStars[i], ' ');
        }

        stars(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                sb.append(myStars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
