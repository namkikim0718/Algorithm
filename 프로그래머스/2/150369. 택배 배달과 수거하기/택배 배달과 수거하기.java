import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        /*  
            전체 배달할 개수 == 0 && 전체 수거할 개수 == 0 될때까지 반복
            제일 먼 곳의 인덱스 찾기 (deliveries != 0 || pickups != 0)
            제일 먼 곳 인덱스 부터 앞으로 오면서 최대 cap개의 deliveries를 -1
            최대 cap개의 pickups도 -1
            >> 반복
        */
        int totalDeliverCnt = 0;
        int totalPickupCnt = 0;
        for (int i = 0; i < n; i++) {
            totalDeliverCnt += deliveries[i];
            totalPickupCnt += pickups[i];
        }
        
        int maxDeliverIdx = n - 1;
        int maxPickupIdx = n - 1;

        
        while (totalDeliverCnt > 0 || totalPickupCnt > 0) {
            
            while(maxDeliverIdx >= 0 && deliveries[maxDeliverIdx] == 0) {
                maxDeliverIdx--;
            }
            
            // maxIdx 부터 앞으로 오면서 최대 cap개의 deliveries 감소
            int deliverCnt = cap;
            for (int i = maxDeliverIdx; i >= 0; i--) {
                
                if (deliveries[i] == 0) continue;
            
                if (deliveries[i] < deliverCnt) {
                    deliverCnt -= deliveries[i];
                    totalDeliverCnt -= deliveries[i];
                    deliveries[i] = 0;
                } else {
                    totalDeliverCnt -= deliverCnt;
                    deliveries[i] -= deliverCnt;
                    deliverCnt = 0;
                    break;
                }
            }
        
            while(maxPickupIdx >= 0 && pickups[maxPickupIdx] == 0) {
                maxPickupIdx--;
            }
            
            // maxIdx 부터 앞으로 오면서 최대 cap개의 pickups 감소
            int pickupCnt = cap;
            for (int i = maxPickupIdx; i >= 0; i--) {
                
                if (pickups[i] == 0) continue;
            
                if (pickups[i] < pickupCnt) {
                    pickupCnt -= pickups[i];
                    totalPickupCnt -= pickups[i];
                    pickups[i] = 0;
                } else {
                    totalPickupCnt -= pickupCnt;
                    pickups[i] -= pickupCnt;
                    pickupCnt = 0;
                    break;
                }
            }
            
            answer += (Math.max(maxDeliverIdx, maxPickupIdx) + 1) * 2;
            
        }
        
        return answer;
    }
}