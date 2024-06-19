import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> timeMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String number = st.nextToken();
            String mode = st.nextToken();
            
            if (mode.equals("IN")) {
                map.put(number, time);
            } else if (mode.equals("OUT")) {
                String inTime = map.get(number);
                int inH = Integer.parseInt(inTime.substring(0, 2));
                int inM = Integer.parseInt(inTime.substring(3, 5));
                int outH = Integer.parseInt(time.substring(0, 2));
                int outM = Integer.parseInt(time.substring(3, 5));
                
                int diff = (outH * 60 + outM) - (inH * 60 + inM);
                timeMap.put(number, timeMap.getOrDefault(number, 0) + diff);
                
                map.remove(number);
            }
        }
        
        for (String key : map.keySet()) {
            String inTime = map.get(key);
            int inH = Integer.parseInt(inTime.substring(0, 2));
            int inM = Integer.parseInt(inTime.substring(3, 5));
            int diff = (23 * 60 + 59) - (inH * 60 + inM);
            timeMap.put(key, timeMap.getOrDefault(key, 0) + diff);
        }
        
        ArrayList<String> keySet = new ArrayList<>(timeMap.keySet());
        Collections.sort(keySet);
        int[] answer = new int[timeMap.size()];
        int i = 0;
        for (String x : keySet) {
            int totalTime = timeMap.get(x);
            int fee = 0;
            if (totalTime > fees[0]) {
                if ((totalTime - fees[0]) % fees[2] != 0) {
                    fee = fees[1] + ((totalTime - fees[0]) / fees[2] + 1) * fees[3];
                } else {
                    fee = fees[1] + (totalTime - fees[0]) / fees[2] * fees[3];
                }
            } else {
                fee = fees[1];
            }
            answer[i++] = fee;
        }
        
        return answer;
    }
}