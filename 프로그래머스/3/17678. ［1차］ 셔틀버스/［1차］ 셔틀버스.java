import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        // timetable을 정수로 변환해서 정렬하고,
        // 0900시 부터 t간격으로 사람을 태워서 보내자.
        // 마지막 차를 따질때, 자리가 남으면 그 시간에 그냥 줄을 서고,
        // 마지막 차에 자리가 모자라면 제일 늦게 온 사람보다 1분 일찍 줄을 서면 된다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            String[] splitTime = time.split(":");
            int hour = Integer.parseInt(splitTime[0]) * 100;
            int minute = Integer.parseInt(splitTime[1]);
            pq.offer(hour + minute);
        }
        
        int nowTime = 900;
        int passenger = 0;
        int lastTime = 0;
        int myTime = 0;
        
        for (int i = 1; i <= n; i++) {
            passenger = 0;
            
            // 큐를 순회
            while (!pq.isEmpty()) {
                int waitingTime = pq.peek();
                // 승객 수가 m보다 작고, 현재 시간보다 같거나 먼저 온 승객을 한명씩 태우자.
                if (nowTime < waitingTime) break;
                lastTime = pq.poll();
                passenger++;
                if (passenger == m) break;
            }
            
            if (i == n) continue;
            
            nowTime += t;
            // 1160 -> 1100
            int nowHour = nowTime / 100;
            int nowMinute = nowTime - nowHour * 100;
            if (nowMinute >= 60) {
                nowMinute = 0;
                nowHour++;
            }
            nowTime = nowHour * 100 + nowMinute;
        }
        
        // 마지막 셔틀이 왔을때 자리 남으면 셔틀 온 시간에 줄서면 됨
        if (passenger < m) {
            myTime = nowTime;
        }
        // 자리 없으면 마지막 승객이 탑승한 시간 -1
        else {
            myTime = lastTime - 1;
            int nowHour = myTime / 100;
            int nowMinute = myTime - nowHour * 100;
            if (nowMinute == 99) {
                nowMinute = 59;
            }
            myTime = nowHour * 100 + nowMinute;
        }
        
        StringBuilder sb = new StringBuilder();
        if (myTime == 0) {
            return "00:00";
        } else {
            int myHour = myTime / 100;
            int myMinute = myTime - myHour * 100;
            if (myHour < 10) {
                sb.append("0");
            }
            sb.append(myHour + ":");
            if (myMinute < 10) {
                sb.append("0");
            }
            sb.append(myMinute);
        }
        return sb.toString();
        
    }
}