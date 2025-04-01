import java.util.*;
import java.io.*;

public class Main {

    static Set<List<Integer>> set = new LinkedHashSet<>();
    static int N;
    static int M;
    static int[] nums;

    static void recursion(List<Integer> myNums, boolean[] visited) {
        if (myNums.size() == M) {
            set.add(new ArrayList<>(myNums));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                myNums.add(nums[i]);
                visited[i] = true;
                recursion(myNums, visited);
                visited[i] = false;
                myNums.remove(myNums.size() - 1);
            }
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        recursion(new ArrayList<>(), new boolean[N]);


        StringBuilder sb = new StringBuilder();
        for (List<Integer> now : set) {
            for (int x : now) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}