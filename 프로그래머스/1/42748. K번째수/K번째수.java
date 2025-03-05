import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int idx = 0; idx < commands.length; idx++) {
            int[] command = commands[idx];
            
            int start = command[0];
            int end = command[1];
            int order = command[2];
            
            List<Integer> tmp = new ArrayList<>();
            for (int i = start - 1; i < end; i++) {
                tmp.add(array[i]);
            }
            
            Collections.sort(tmp);
            
            answer[idx] = tmp.get(order - 1);
        }
        
        return answer;
    }
}