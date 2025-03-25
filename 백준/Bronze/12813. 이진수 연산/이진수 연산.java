import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String B = br.readLine();

        StringBuilder and = new StringBuilder();
        StringBuilder or = new StringBuilder();
        StringBuilder xor = new StringBuilder();
        StringBuilder notA = new StringBuilder();
        StringBuilder notB = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            if (a == '1' && b == '1') {
                and.append("1");
            } else {
                and.append("0");
            }

            if (a == '1' || b == '1') {
                or.append("1");
            } else {
                or.append("0");
            }

            if (a != b) {
                xor.append("1");
            } else {
                xor.append("0");
            }

            if (a == '1') {
                notA.append("0");
            } else {
                notA.append("1");
            }

            if (b == '1') {
                notB.append("0");
            } else {
                notB.append("1");
            }
        }

        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
        System.out.println(notA);
        System.out.println(notB);
    }
}