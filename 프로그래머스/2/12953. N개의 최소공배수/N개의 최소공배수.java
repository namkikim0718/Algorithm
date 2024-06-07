import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = -1;
        Arrays.sort(arr);
        boolean isMin = false;
        int maxNum = arr[arr.length - 1];
        int k = 1;
        
        while (answer == -1) {
            int nowNum = maxNum * k++;
            boolean allPossible = true;
            for (int x : arr) {
                if (nowNum % x != 0) {
                    allPossible = false;
                    break;
                }
            }
            if (allPossible) {
                answer = nowNum;
            }
        }
        
        return answer;
    }
}