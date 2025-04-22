import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static List<Integer> nums = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();

    static void recursion(int cnt, List<Integer> nowList) {
        if (cnt == M) {
            result.add(new ArrayList<>(nowList));
            return;
        }

        for (int num : nums) {
            if (num >= nowList.get(nowList.size() - 1)) {
                nowList.add(num);
                recursion(cnt + 1, nowList);
                nowList.remove(nowList.size() - 1);
            }
        }

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (nums.contains(now)) continue;

            nums.add(now);
        }

        Collections.sort(nums);

        for (int num : nums) {
            List<Integer> nowList = new ArrayList<>();
            nowList.add(num);

            recursion(1, nowList);
        }

        StringBuilder sb = new StringBuilder();
        for (List<Integer> now : result) {
            for (int x : now) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
