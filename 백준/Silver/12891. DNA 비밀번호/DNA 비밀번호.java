import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int p = sc.nextInt();
        String str = sc.next();

        char[] strArray = new char[s];
        int start = 0;
        int end = p - 1;
        int count = 0;


        for (int i = 0; i < s; i++) {
            strArray[i] = str.charAt(i);
        }

        int A = sc.nextInt();
        int C = sc.nextInt();
        int G = sc.nextInt();
        int T = sc.nextInt();

        int myA = 0;
        int myC = 0;
        int myG = 0;
        int myT = 0;

        for (int i = start; i <= end; i++) {
            if (strArray[i] == 'A') {
                myA++;
            } else if (strArray[i] == 'C') {
                myC++;
            } else if (strArray[i] == 'G') {
                myG++;
            } else if (strArray[i] == 'T') {
                myT++;
            }
        }
        while (true) {
            if ((myA >= A) && (myC >= C) && (myG >= G) && (myT >= T)) {
                count++;
            }

            if (strArray[start] == 'A') {
                myA--;
            } else if (strArray[start] == 'C') {
                myC--;
            } else if (strArray[start] == 'G') {
                myG--;
            } else if (strArray[start] == 'T') {
                myT--;
            }

            start++;
            end++;

            if(end == s) {
                break;
            } else {
                if (strArray[end] == 'A') {
                    myA++;
                } else if (strArray[end] == 'C') {
                    myC++;
                } else if (strArray[end] == 'G') {
                    myG++;
                } else if (strArray[end] == 'T') {
                    myT++;
                }
            }


        }
        System.out.println(count);
    }
}