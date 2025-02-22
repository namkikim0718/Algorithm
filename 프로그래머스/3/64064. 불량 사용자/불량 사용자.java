import java.util.*;

class Solution {
    
    static Set<List<String>> result = new HashSet<>();
    
    static void dfs(String[] user_id, String[] banned_id, int depth, List<String> myList) {
        
        List<String> myNewList = new ArrayList<>(myList);
        
        if (depth == banned_id.length) {
            Collections.sort(myNewList);
            result.add(new ArrayList<>(myNewList));
            return;
        }
        
        String nowBannedId = banned_id[depth];
        for (int idx = 0; idx < user_id.length; idx++) {
            // 이미 제제 아이디랑 일치하는 것으로 된 것은 넘어가도록
            if (myList.contains(user_id[idx])) continue;
            
            String nowUserId = user_id[idx];
            
            // 현재 사용자가 가능한지 아닌지 나타내는 플래그
            boolean isAvailable = true;
            
            // 문자열 길이가 다르면 애초에 같을 수 없음
            if (nowUserId.length() != nowBannedId.length()) continue;
            
            // 문자 하나씩 비교
            for (int i = 0; i < nowUserId.length(); i++) {
                // 제제 아이디의 현재 문자가 *이면 넘어가도록
                if (nowBannedId.charAt(i) == '*') continue;
                if (nowUserId.charAt(i) != nowBannedId.charAt(i)) {
                    isAvailable = false;
                    break;
                }
            }
            
            // 현재 사용자 아이디가 가능하면 재귀로 탐색
            if (isAvailable) {
                myNewList.add(user_id[idx]);
                dfs(user_id, banned_id, depth+1, myNewList);
                myNewList.remove(myNewList.size() - 1);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {

        dfs(user_id, banned_id, 0, new ArrayList<>());
        
        return result.size();
    }
}