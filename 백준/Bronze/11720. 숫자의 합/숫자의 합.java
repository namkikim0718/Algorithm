import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();
        String strNum = sc.next();
        String[] arrayNum = strNum.split("");
        long result = 0;


        for(int i = 0; i < inputNum ; i++) {
            result += Integer.parseInt(arrayNum[i]);
        }

        System.out.println(result);

    }
}