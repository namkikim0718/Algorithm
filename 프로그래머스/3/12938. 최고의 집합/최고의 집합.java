import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if (n > s) return new int[]{-1};
        
        int divided = s / n;
        int remain = s % n;
        
        Arrays.fill(answer, divided);
        
        for (int i = n - 1; i > n - 1 - remain; i--) {
            answer[i]++;
        }
        
        
        return answer;
    }
}