import java.util.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        
        for (int i = 0; i < phoneBook.length - 1; i++) {
            String A = phoneBook[i];
            String B = phoneBook[i + 1];
            if (B.startsWith(A)) {
                return false;
            }
        }
        
        return true;
    }
}