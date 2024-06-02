import java.util.*;

class Solution {
    public StringBuilder solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> list = new ArrayList<>();
        
        while (st.hasMoreElements()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int x : list) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min + " " + max);
        
        return sb;
    }
}