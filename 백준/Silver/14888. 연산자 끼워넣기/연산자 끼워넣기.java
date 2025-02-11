import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] operators = new int[4];
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    static void dfs(int result, int cnt) {
        if (cnt == N) {
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;

            operators[i]--;
            
            int newResult = calculate(i, result, nums[cnt]);

            dfs(newResult, cnt + 1);

            operators[i]++;
        }
    }

    static int calculate(int operator, int num1, int num2) {
        if (operator == 0) {
            return num1 + num2;
        } else if (operator == 1) {
            return num1 - num2;
        } else if (operator == 2) {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i ++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);

    }
}