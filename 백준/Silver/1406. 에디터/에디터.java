import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        for (char each : input.toCharArray()) {
            left.push(String.valueOf(each));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0;i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("P")) {
                String newChar = st.nextToken();
                left.push(newChar);
            } else if (command.equals("L")) {
                if (left.isEmpty()) continue;
                right.push(left.pop());
            } else if (command.equals("D")) {
                if (right.isEmpty()) continue;
                left.push(right.pop());
            } else if (command.equals("B")) {
                if (left.isEmpty()) continue;
                left.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse();

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb.toString());
    }
}