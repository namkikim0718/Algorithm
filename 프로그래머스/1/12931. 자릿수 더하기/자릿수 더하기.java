import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String str = Integer.toString(n);
        for (char x : str.toCharArray()) {
            answer += Character.getNumericValue(x);
        }

        return answer;
    }
}