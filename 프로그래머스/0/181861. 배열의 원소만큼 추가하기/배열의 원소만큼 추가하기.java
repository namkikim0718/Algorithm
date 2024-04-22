import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int len = Arrays.stream(arr).sum();
        int[] result = new int[len];
        
        int index = 0;
        for (int num : arr) {
            for (int i = 0; i < num; i++) {
                result[index++] = num;
            }
        }
        return result;
    }
}