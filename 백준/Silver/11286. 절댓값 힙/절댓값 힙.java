import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] input = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first == second) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return first - second;
        });

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (input[i] != 0) {
                queue.add(input[i]);
            } else if (input[i] == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(queue.poll());
                }
            }
        }

    }
}