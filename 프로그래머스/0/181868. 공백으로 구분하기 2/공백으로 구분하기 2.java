import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> result = new ArrayList<>();
        
        String myStr = "";
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (ch != ' ') {
                myStr += ch;
            } else if (ch == ' ' && myStr != "") {
                result.add(myStr);
                myStr = "";
            }
        }
        if (myStr != "") {
            result.add(myStr);
        }
        return result.stream()
            .toArray(String[]::new);
        
    }
}