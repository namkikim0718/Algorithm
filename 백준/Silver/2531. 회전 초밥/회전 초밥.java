import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }

        int maxCnt = map.size();
        if (!map.containsKey(c)) {
            maxCnt++;
        }

        for (int i = 0; i < N; i++) {
            map.put(sushi[i], map.get(sushi[i]) - 1);
            if (map.get(sushi[i]) <= 0) {
                map.remove(sushi[i]);
            }
            map.put(sushi[(i + k) % N], map.getOrDefault(sushi[(i + k) % N], 0) + 1);

            int nowCnt = map.size();
            if (!map.containsKey(c)) {
                nowCnt++;
            }

            maxCnt = Math.max(maxCnt, nowCnt);
        }

        System.out.println(maxCnt);
    }
}