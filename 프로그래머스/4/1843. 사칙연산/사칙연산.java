import java.util.*;

class Solution {
    public int solution(String arr[]) {

        // 숫자 개수
        int n = arr.length / 2 + 1;
        int[][] dpMin = new int[n][n];
        int[][] dpMax = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dpMin[i][i] = Integer.parseInt(arr[i * 2]);
            dpMax[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = len + i;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
                
                // k 번째 연산자 기준으로 i ~ k, k+1 ~ j 구간
                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];
                    
                    if (op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + dpMax[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + dpMin[k+1][j]);
                    } else {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] - dpMin[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] - dpMax[k+1][j]);
                    }
                }
            }
        }
        
        return dpMax[0][n-1];
    }
}