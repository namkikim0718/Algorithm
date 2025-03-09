import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        int n = numbers.length;
        String[] numStrs = new String[n];
        
        for (int i = 0; i < n; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numStrs, (a, b) -> {
            return (b+a).compareTo(a+b);
        });
        
        if (numStrs[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }
        
        return sb.toString();
    }
}