import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = sc.nextInt();
        int[] numArray = new int[num+1];

        for (int i = 1; i <= num; i++) {
            numArray[i] = sc.nextInt();
        }
        int[] smallIndex = new int[count+1];
        int[] largeIndex = new int[count+1];

        for (int i = 1; i <= count; i++) {
            smallIndex[i] = sc.nextInt();
            largeIndex[i] = sc.nextInt();
        }

        int[] sum = new int[num+1];
        sum[1] = numArray[1];
        for (int i = 1; i <= num; i++) {
            sum[i] = sum[i - 1] + numArray[i];
        }
        for (int i = 1; i <= count; i++) {
            System.out.println(sum[largeIndex[i]] - sum[smallIndex[i]-1]);
        }
    }
}