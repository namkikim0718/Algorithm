import java.util.*;

class Solution {
    static int length = 0;
    static Set<Integer> set = new HashSet<>();
    static int[] nums;
    static boolean[] isSelected;
    
    public static void dfs(int now, int cnt) {
        if (cnt >= length) {
            if (now < 2) {
                return;
            }
            boolean isPossible = true;
            for (int i = 2; i < now; i++) {
                if (now % i == 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                set.add(now);
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (isSelected[i]) continue;
                isSelected[i] = true;
                dfs(now * 10 + nums[i], cnt+1);
                dfs(now, cnt+1);
                isSelected[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        
        length = numbers.length();   
        nums = new int[length];
        isSelected = new boolean[length];
        
        for (int i = 0; i < length; i++) {
            nums[i] = Character.getNumericValue(numbers.charAt(i));
        }
        
        dfs(0, 0);
        
        return set.size();
    }
}