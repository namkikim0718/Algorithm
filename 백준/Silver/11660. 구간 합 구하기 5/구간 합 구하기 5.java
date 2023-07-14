import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] numbers = new int[N+1][N+1];
        int[] x1 = new int[M+1];
        int[] y1 = new int[M+1];
        int[] x2 = new int[M+1];
        int[] y2 = new int[M+1];



        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= M; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }

        int[][] sumNum = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int sum = 0;
                if(j == 1) {
                    sum = sumNum[i-1][j] + numbers[i][j];
                } else {
                    sum = sumNum[i][j - 1] + sumNum[i - 1][j] + numbers[i][j] - sumNum[i - 1][j - 1];
                }
                sumNum[i][j] = sum;
            }
        }

        for (int i = 1; i <= M; i++) {
            int result = 0;

            result = sumNum[x2[i]][y2[i]]
                    - sumNum[x1[i]-1][y2[i]]
                    - sumNum[x2[i]][y1[i]-1]
                    + sumNum[x1[i]-1][y1[i]-1];

            System.out.println(result);
        }


    }
}