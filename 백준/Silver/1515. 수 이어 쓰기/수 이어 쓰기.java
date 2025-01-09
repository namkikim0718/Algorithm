import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int idx = 0;
        int minNum = 0;
        while (idx < input.length()) {
            minNum++;

            String now = String.valueOf(minNum);

            for (char x : now.toCharArray()) {
                if (idx < input.length() && input.charAt(idx) == x) {
                    idx++;
                }
            }
        }

        System.out.println(minNum);
    }
}