import java.util.*;

public class Main {

    public static int Solution(int N) {
        int x = 1;
        int level = 1;
        while (x < N) {
            x = x + 6 * level++;
        }
        return level;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();

        System.out.println(Solution(N));
        
    }
}