import java.util.*;
import java.io.*;

public class Main {


    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (queue.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else {
                queue.offer(input);
            }
        }

        System.out.println(sb.toString().trim());

    }
}