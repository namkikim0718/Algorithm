import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] sortList = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sortList[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(sortList, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (sortList[0].equals("0")) {
            return "0";
        }
        
        for (String x : sortList) {
            sb.append(x);
        }
        
        return sb.toString();
    }
}