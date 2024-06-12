import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String s) {        
        ArrayList<Integer> answer = new ArrayList<>();
        
        String str = s.substring(2, s.length() - 2);

        String[] list = str.split("\\},\\{");
        
        Arrays.sort(list, (o1, o2) -> o1.length() - o2.length());
        for (String x : list) {
            String[] numList = x.split(",");
            for (String cutNum : numList) {
                int nowNum = Integer.parseInt(cutNum);
                if (!answer.contains(nowNum)) {
                    answer.add(nowNum);
                }
            }
        }
        
        return answer;
    }
}