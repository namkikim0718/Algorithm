import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        List<String> numStrs = new ArrayList<>();
        
        for (int number : numbers) {
            numStrs.add(String.valueOf(number));
        }
        
        Collections.sort(numStrs, (a, b) -> {
           return (b + a).compareTo(a + b);
        });
        
        if (numStrs.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }
        
        return sb.toString();
    }
}