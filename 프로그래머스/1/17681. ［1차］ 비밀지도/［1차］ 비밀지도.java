class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        int[][] graph1 = new int[n][n];
        int[][] graph2 = new int[n][n];
        
        String[] answer = new String[n];
        
        // graph1에 arr1을 0과 1로 된 이차원 배열로 저장
        for (int i = 0; i < n; i++) {
            String binaryStr = Integer.toBinaryString(arr1[i]);
            for (int k = 0; k < n - binaryStr.length(); k++) {
                graph1[i][k] = 0;
            }
            int idx = n - binaryStr.length();
            for (char x : binaryStr.toCharArray()) {
                graph1[i][idx++] = Character.getNumericValue(x);
            }
        }
        
        // graph2에 arr2를 0과 1로 된 이차원 배열로 저장
        for (int i = 0; i < n; i++) {
            String binaryStr = Integer.toBinaryString(arr2[i]);
            for (int k = 0; k < n - binaryStr.length(); k++) {
                graph2[i][k] = 0;
            }
            int idx = n - binaryStr.length();
            for (char x : binaryStr.toCharArray()) {
                graph2[i][idx++] = Character.getNumericValue(x);
            }
        }
        
        // 두개의 이차원 배열을 순회하며 공백과 벽으로 이루어진 answer 만들기
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (graph1[i][j] == 0 && graph2[i][j] == 0) {
                    sb.append(" ");
                    continue;
                }
                sb.append("#");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}