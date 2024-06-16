import java.util.*;

class Solution {
    
    static boolean[] isSelected;
    static Set<String> set = new HashSet<>();
    
    public static boolean check(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        } else {
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i) && B.charAt(i) != '*') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void dfs(String[] userId, String[] bannedId, int idx, String str) {
        if (idx == bannedId.length) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            set.add(new String(charArr));
            return;
        }
        for (int i = 0; i < userId.length; i++) {
            if (!isSelected[i] && check(userId[i], bannedId[idx])) {
                isSelected[i] = true;
                dfs(userId, bannedId, idx+1, str + i);
                isSelected[i] = false;
            }
        }
    }
    
    public int solution(String[] userId, String[] bannedId) {
        isSelected = new boolean[userId.length];
        String str = "";
        
        dfs(userId, bannedId, 0, str);
        
        return set.size();
    }
}