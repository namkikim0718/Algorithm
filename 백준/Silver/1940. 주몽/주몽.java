import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long M = sc.nextInt();
        int[] num = new int[N];

        int startIndex = 0;
        int endIndex = 1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        while (true) {
            long sum = num[endIndex] + num[startIndex];
            if (sum == M) {
                count++;
            }
            if(endIndex < N - 1) {
                endIndex++;
            } else {
                startIndex++;
                endIndex = startIndex + 1;
            }

            if (startIndex == N - 1) {
                break;
            }
        }

        System.out.println(count);
    }
}