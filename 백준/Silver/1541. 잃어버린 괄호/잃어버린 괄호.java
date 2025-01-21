import java.util.*;
import java.io.*;

public class Main {

    
    
    public static void main(String args[]) throws IOException {
        // - 연산자가 나오면 그 뒤에 다시 -연산자가 나올때까지 다 빼면 될 것 같다.
        // 연산자랑 숫자를 따로 배열에 넣고 각각 하나씩 꺼내서 처리하자.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        List<Character> operators = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        String numStr = "";
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (now == '-' || now == '+') {
                nums.add(Integer.parseInt(numStr));
                numStr = "";
                operators.add(now);
                continue;
            }
            numStr += String.valueOf(now);
        }
        nums.add(Integer.parseInt(numStr));

        int answer = nums.remove(0);
        boolean isMinus = false;
        
        for (int i = 0; i < operators.size(); i++) {
            char operator = operators.get(i);
            int num = nums.get(i);

            if (operator == '-') {
                isMinus = true;
                answer -= num;
            } else {
                if (!isMinus) {
                    answer += num;
                } else {
                    answer -= num;
                }
            }
        }

        System.out.println(answer);

    }
}