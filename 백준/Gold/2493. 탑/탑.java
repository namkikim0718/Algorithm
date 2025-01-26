import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        int[] result = new int[N+1];

        for (int i = 1; i <= N; i++) {

            while(!stack.isEmpty() && stack.peek()[0] <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[1];
            } else {
                result[i] = 0;
            }

            stack.push(new int[]{arr[i], i});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i] + " ");
        }

        System.out.println(sb.toString().trim());

    }
}