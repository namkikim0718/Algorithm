import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String operation : operations) {
            String[] operArr = operation.split(" ");
            String command = operArr[0];
            int num = Integer.parseInt(operArr[1]);
            
            if (command.equals("I")) {
                pq.offer(num);
            } else {
                if (pq.isEmpty()) continue;
                if (pq.size() == 1) {
                    pq.poll();
                    continue;
                }
                if (num == 1) {
                    List<Integer> temp = new ArrayList<>();
                    while (!pq.isEmpty()) {
                        temp.add(pq.poll());
                    }
                    temp.remove(temp.size() - 1);
                    for (int x : temp) {
                        pq.offer(x);
                    }
                } else {
                    pq.poll();
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        int[] answer = new int[2];
        if (result.isEmpty()) {
            return new int[]{0, 0};
        }
        answer[0] = result.get(result.size() - 1);
        answer[1] = result.get(0);
        return answer;
    }
}