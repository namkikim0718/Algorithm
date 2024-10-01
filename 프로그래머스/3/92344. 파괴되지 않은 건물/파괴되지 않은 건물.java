class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        
        for (int[] nowSkill : skill) {
            int type = nowSkill[0];
            int r1 = nowSkill[1];
            int c1 = nowSkill[2];
            int r2 = nowSkill[3];
            int c2 = nowSkill[4];
            int degree = nowSkill[5];
            
            if (type == 1) {
                sum[r1][c1] -= degree;
                sum[r1][c2 + 1] += degree;
                sum[r2 + 1][c1] += degree;
                sum[r2 + 1][c2 + 1] -= degree;
            } if (type == 2) {
                sum[r1][c1] += degree;
                sum[r1][c2 + 1] -= degree;
                sum[r2 + 1][c1] -= degree;
                sum[r2 + 1][c2 + 1] += degree;
            }
        }
        
        for (int col = 0; col < board[0].length + 1; col++) {
            for (int row = 0; row < board.length; row++) {
                sum[row + 1][col] += sum[row][col];
            }
        }
        
        for (int row = 0; row < board.length + 1; row++) {
            for (int col = 0; col < board[0].length; col++) {
                sum[row][col + 1] += sum[row][col];
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int now = board[i][j] + sum[i][j];
                if (now > 0) answer++;
            }
        }
        
        return answer;
    }
}