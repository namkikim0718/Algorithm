import java.util.*;

public class Main {

    public static Long Solution(int A, int B) {
        Queue<Long> queue = new LinkedList<>();
        Map<Long, Long> cnt = new HashMap<>();
        
        cnt.put(Long.valueOf(A), 1L);
        queue.offer(Long.valueOf(A));

        while (!queue.isEmpty()) {
            Long x = queue.poll();

            if (x == B) return cnt.get(x);

            if (x * 10 + 1 <= B && !cnt.containsKey(x*10+1)) {
                queue.offer(Long.valueOf(x*10 + 1));
                cnt.put(Long.valueOf(x*10+1), Long.valueOf(cnt.get(x)+1));
            }
            if (x * 2 <= B && !cnt.containsKey(x*2)) {
                queue.offer(Long.valueOf(x*2));
                cnt.put(Long.valueOf(x*2), Long.valueOf(cnt.get(x) + 1));
            }
            
        }
        return -1L;

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int A = kb.nextInt();
        int B = kb.nextInt();

        System.out.println(Solution(A, B));
    }
}