import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            int first = 0;
            int second = N-1;
            while (first < second) {
                if (A[first] + A[second] == A[i]) {
                    if (first != i && second != i) {
                        count++;
                        break;
                    } else if (first == i) {
                        first++;
                    } else if (second == i) {
                        second--;
                    }
                } else if (A[first] + A[second] < A[i]) {
                    first++;
                } else if (A[first] + A[second] > A[i]) {
                    second--;
                }
            }
        }
        System.out.println(count);
    }
}