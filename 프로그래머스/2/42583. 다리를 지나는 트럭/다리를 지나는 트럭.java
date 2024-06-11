import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        
        Queue<Integer> onBridge = new LinkedList<>();
        
        for (int i = 0; i < bridgeLength; i++) {
            onBridge.offer(0);
        }
        
        int sum = 0;
        int index = 0;
        while(index < truckWeights.length) {
            
            sum -= onBridge.poll();
            answer++;
            
            if (sum + truckWeights[index] <= weight) {
                sum += truckWeights[index];
                onBridge.offer(truckWeights[index++]);
            } else {
                onBridge.offer(0);
            }
        }
        
        return answer + bridgeLength;
    }
}