import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int r;
    static int c;
    static int result;

    static void zigzag(int x, int y, int order, int depth) {
        // size가 1일때까지 타고 들어가야하는데, r과 c의 범위에 따라서 들어가게 해야 한다.
        if (depth > N) {
            result = order;
            return;
        }

        int boxSize = (int) Math.pow(2, 2 * N - 2 * depth);

        if (r >= x && r < x + (int) Math.pow(2, N - depth) && c >= y && c < y + (int) Math.pow(2, N - depth)) {
            zigzag(x, y, order, depth + 1);
        }  else if (r >= x && r < x + (int) Math.pow(2, N - depth) && c >= y + (int) Math.pow(2, N - depth) && c < y + (int) Math.pow(2, N - depth + 1)) {
            zigzag(x, y + (int) Math.pow(2, N - depth), order + boxSize, depth + 1);
        } else if (r >= x + (int) Math.pow(2, N - depth) && r < x + (int) Math.pow(2, N - depth + 1) && c >= y && c < y + (int) Math.pow(2, N - depth)) {
            zigzag(x + (int) Math.pow(2, N - depth), y, order + 2 * boxSize, depth + 1);
        } else {
            zigzag(x + (int) Math.pow(2, N - depth), y + (int) Math.pow(2, N - depth), order + 3 * boxSize, depth + 1);
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        zigzag(0, 0, 0, 0);

        System.out.println(result);

    }
}
