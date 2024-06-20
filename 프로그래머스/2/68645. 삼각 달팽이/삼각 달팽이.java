import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] arr = new int[n][n];
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max += i;
        }
        
        int minCol = 0;
        int colDist = 0;
        int minRow = 1;
        int maxRow = n - 1;
        int i = 0;
        int j = 0;
        int cnt = 1;
        
        int direction = 1;
        while(cnt <= max) {
            arr[i][j] = cnt++;
            // down
            if (direction == 1) {
                if (i + 1 > maxRow) {
                    direction = 2;
                    minCol++;
                    j++;
                } else {
                    i++;
                }
            }
            // right
            else if (direction == 2) {
                if (j + 1 > i - colDist) {
                    direction = 3;
                    maxRow--;
                    i--;
                    j--;
                } else {
                    j++;
                }
            }
            // upper-left
            else if (direction == 3) {
                if (j - 1 < minCol || i - 1 < minRow) {
                    direction = 1;
                    minRow++;
                    colDist++;
                    i++;
                } else {
                    i--;
                    j--;
                }
            }

        }
        
        for (int[] r : arr) {
            for (int x : r) {
                if (x == 0) break;
                else {
                    answer.add(x);
                }
            }
        }
        
        return answer;
    }
}