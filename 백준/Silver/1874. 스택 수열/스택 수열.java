import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numArray = new int[n];
        Stack<Integer> myStack = new Stack<>();
        char[] resultList = new char[n * 2];
        int resultIndex = 0;
        boolean possible = true;

        int k = 0;
        for (int i = 0; i < n; i++) {
            numArray[i] = sc.nextInt();
        }

        int cnt = 0;
        while(cnt < n) {
            if (k >= numArray[cnt]) {
                while (!myStack.empty() && myStack.peek() >= numArray[cnt]) {
                    int nowNum = myStack.pop();
                    if (nowNum > numArray[cnt]) {
                        possible = false;
                        break;
                    }
                    resultList[resultIndex++] = '-';
                }

                cnt++;
            } else {
                while(k < numArray[cnt]) {
                    myStack.push(++k);
                    resultList[resultIndex++] = '+';
                }
            }
        }

        if (possible) {
            for (int i = 0; i < n * 2; i++) {
                System.out.println(resultList[i]);
            }
        } else {
            System.out.println("NO");
        }
    }
}