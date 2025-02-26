import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int n = routes.length;
        
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });
        List<Integer> cameras = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            
            boolean detected = false;
            for (int camera : cameras) {
                if (camera >= start && camera <= end) {
                    detected = true;
                    break;
                }
            }
            if (!detected) {
                cameras.add(end);
            }
        }
        
        
        return cameras.size();
    }
}