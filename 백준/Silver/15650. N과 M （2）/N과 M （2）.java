import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void recursion(int depth, List<Integer> nums) {
        List<Integer> newNums = new ArrayList<>(nums);

        if (depth == N + 1) {
            if (newNums.size() == M) {
                result.add(newNums);
            }
            return;
        }

        recursion(depth + 1, newNums);
        newNums.add(depth);
        recursion(depth + 1, newNums);
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursion(1, new ArrayList<>());

        for (int i = result.size() - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                sb.append(result.get(i).get(j) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}