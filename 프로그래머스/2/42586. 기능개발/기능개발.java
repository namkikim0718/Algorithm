import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] time = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int need = 100 - progresses[i];
            if (need % speeds[i] == 0) {
                time[i] = (need / speeds[i]);
            } else {
                time[i] = (need / speeds[i] + 1);
            }
        }
        
        boolean isDone = false;
        while (!isDone) {
            int cnt = 0;
            int today = 0;
            for (int i = 0; i < time.length; i++) {
                if (time[i] != -1) {
                    today = time[i];
                    break;
                }
            }
            for (int i = 0; i < time.length; i++) {
                if (i == 0 || time[i - 1] == -1) {
                    if (time[i] != -1 && time[i] <= today) {
                        time[i] = -1;
                        cnt++;
                    }
                }
            }
            answer.add(cnt);
            
            isDone = true;
            for (int i = 0; i < time.length; i++) {
                if (time[i] != -1) {
                    isDone = false;
                }
            }
        }
    
        
        
        return answer;
    }
}