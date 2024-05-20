import java.util.*;

public class Main {

    public static int Solution(int H, int W, int N, int M) {
        int a = 0;
        int b = 0;
        if (H % (N + 1) != 0) {
            a = H / (N+1) + 1;
        } else {
            a = H / (N+1);
        }

        if (W % (M + 1) != 0) {
            b = W / (M+1) + 1;
        } else {
            b = W / (M+1);
        }
        return a*b;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int H = kb.nextInt();
        int W = kb.nextInt();
        int N = kb.nextInt();
        int M = kb.nextInt();

        System.out.println(Solution(H, W, N, M));
    }
}