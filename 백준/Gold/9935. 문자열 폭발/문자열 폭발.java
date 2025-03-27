import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() < bomb.length()) continue;

            boolean isBomb = true;
            for (int j = 0; j < bomb.length(); j++) {
                if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
                    isBomb = false;
                    break;
                }
            }

            if (isBomb) {
                sb.delete(sb.length() - bomb.length(), sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

    }
}