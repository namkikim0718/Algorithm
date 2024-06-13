import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;;
        
        
        int cutSize = 1;
        
        
        while (cutSize <= s.length()) {
            ArrayList<String> list = new ArrayList<>(); 
            int idx = 0;
            
            while (idx < s.length()) {
                if (idx + cutSize >= s.length()) {
                    list.add(s.substring(idx, s.length()));
                } else {
                    list.add(s.substring(idx, idx + cutSize));
                }
                
                idx += cutSize;
            }
            
            int i = 1;
            String before = list.get(0);
            int cnt = 0;
            
            String myStr = "";
            while (i < list.size()) {
                if (list.get(i).equals(before)){
                    cnt++;
                } else {
                    if (cnt != 0) {
                        myStr = myStr + (cnt+1) + before;    
                    } else {
                        myStr += before;
                    }                    
                    cnt = 0;
                    before = list.get(i);
                }
                i++;
            }
            if (cnt != 0) {
                myStr = myStr + (cnt+1) + before;
            } else {
                myStr += before;
            }
            
            answer = Math.min(answer, myStr.length());
            cutSize++;
        }
        
        return answer;
    }
}