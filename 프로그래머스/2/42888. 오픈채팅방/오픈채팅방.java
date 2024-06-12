import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        
        for (String x : record) {
            StringTokenizer st = new StringTokenizer(x);
            String mode = st.nextToken();
            if (mode.equals("Enter") || mode.equals("Change")) {
                map.put(st.nextToken(), st.nextToken());
            }
        }
        
        for (String x : record) {
            StringTokenizer st = new StringTokenizer(x);
            String mode = st.nextToken();
            if (mode.equals("Enter")) {
                String id = st.nextToken();
                answer.add(map.get(id) + "님이 들어왔습니다.");
            } else if (mode.equals("Leave")) {
                String id = st.nextToken();
                answer.add(map.get(id) + "님이 나갔습니다.");
            }
        }
        
        
        return answer;
    }
}