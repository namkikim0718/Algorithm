import java.util.*;

class Solution {
    
    static long convertToMillis(String timeStr) {
        String[] timeParts = timeStr.split("[:.]");
        long hour = Long.parseLong(timeParts[0]) * 60 * 60 * 1000;
        long minute = Long.parseLong(timeParts[1]) * 60 * 1000;
        long second = Long.parseLong(timeParts[2]) * 1000;
        long millis = Long.parseLong(timeParts[3]);
        
        return hour + minute + second + millis;
    }
    
    public int solution(String[] lines) {
        int answer = 0;
        
        List<long[]> logs = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            long endMillis = convertToMillis(parts[1]);
            long processMillis = (long) (Double.parseDouble(parts[2].replace("s", "")) * 1000);
            long startMillis = endMillis - processMillis + 1;
            
            logs.add(new long[]{startMillis, endMillis});
        }
        
        for (long[] log : logs) {
            long startWindow = log[1];
            long endWindow = startWindow + 1000;
            
            int cnt = 0;
            for (long[] otherLog : logs) {
                if (otherLog[1] >= startWindow && otherLog[0] < endWindow) {
                    cnt++;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}