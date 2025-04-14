import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] copyArr = new int[N];
        for (int i = 0; i < N; i++) {
            copyArr[i] = arr[i];
        }
        Arrays.sort(copyArr);

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> uniqueNums = new ArrayList<>();
        int idx = 0;
        for (int x : copyArr) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(map.get(x) + " ");
        }

        System.out.println(sb.toString().trim());

    }
}
