import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();


        long[] sumA = new long[N];
        long[] countRemain = new long[M];

        sumA[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            sumA[i] = sumA[i - 1] + sc.nextLong();
        }

        long answer = 0;

        for (int i = 0; i < N; i++) {
            int remainA = (int)(sumA[i] % M);
            if(remainA == 0) answer++;
            countRemain[remainA]++;
        }

        for (int i = 0; i < M; i++) {
            if (countRemain[i] > 1) {
                answer = answer + (countRemain[i] * (countRemain[i] - 1) / 2);
            }
        }


        System.out.println(answer);
    }
}
