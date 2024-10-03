import java.util.*;

class Solution {
    static int cnt = 0;
    static int length;
    
    public void dfs(int[] numbers, int target, int level, int sum) {
        if (level == length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        
        dfs(numbers, target, level + 1, sum + numbers[level]);
        dfs(numbers, target, level + 1, sum - numbers[level]);
    }
    
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        
        dfs(numbers, target, 0, 0);
        
        return cnt;
    }
}