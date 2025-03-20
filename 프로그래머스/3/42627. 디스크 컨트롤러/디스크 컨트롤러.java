import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0]; 
        });
        
        // a[0] : 작업 번호, a[1] : 작업 요청 시각, a[2] : 작업 소요시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
            return a[2] - b[2]; 
        });
        
        boolean[] isDone = new boolean[jobs.length];
        int nowTime = 0;
        int totalReturnTime = 0;
        int jobIdx = 0;
        
        while (true) {
            
            boolean isAllDone = true;
            for (boolean now : isDone) {
                if (!now) {
                    isAllDone = false;
                    break;
                }
            }
            if (isAllDone) {
                break;
            }
            
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= nowTime) {
                pq.offer(new int[]{jobIdx, jobs[jobIdx][0], jobs[jobIdx][1]});
                jobIdx++;
            }

            
            // 대기 큐에 작업이 있으면 꺼내서 처리
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                int jobNum = job[0];
                int comeTime = job[1];
                int needTime = job[2];

                int finishTime = nowTime + needTime;
                totalReturnTime += finishTime - comeTime;
                
                nowTime = finishTime;
                isDone[jobNum] = true;
            } else {
                nowTime++;
            }
        }
        
        return totalReturnTime / jobs.length;
    }
}