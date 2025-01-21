import java.util.*;
import java.io.*;

public class Main {

    
    
    public static void main(String args[]) throws IOException {
        // 시작시간이 같은 경우 끝시간이 가장 작은 것이 우선순위가 된다.
        // 하지만 1 3, 3 9, 4 5 인 경우 3 9 보다 4 5가 더 우선적으로 배정되어야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int start = times[i][0];
            int end = times[i][1];

            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }
            minHeap.offer(end);
        }

        System.out.println(minHeap.size());
    }
}