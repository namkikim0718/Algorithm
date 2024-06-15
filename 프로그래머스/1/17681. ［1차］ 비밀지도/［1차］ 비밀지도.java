class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] map = new int[n][n];
        
        
        for (int i = 0; i < n; i++) {
            int x = arr1[i];
            int y = arr2[i];
            String lineX = Integer.toBinaryString(x);
            String lineY = Integer.toBinaryString(y);
            
            if (lineX.length() < n) {
                int sizeX = n - lineX.length();
                for (int k = 0; k < sizeX; k++) {
                    lineX = "0" + lineX;
                }
            }
            if (lineY.length() < n) {
                int sizeY = n - lineY.length();
                for (int k = 0; k < sizeY; k++) {
                    lineY = "0" + lineY;
                }
            }
            
            for (int j = 0; j < n; j++) {
                if (lineX.charAt(j) == '0' && lineY.charAt(j) == '0') {
                    map[i][j] = 0;   
                }
                else {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    tmp += " ";
                } else {
                    tmp += "#";
                }
            }
            answer[i] = tmp;
        }
        
        return answer;
    }
}