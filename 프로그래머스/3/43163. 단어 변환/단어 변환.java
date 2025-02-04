class Solution {
    
    static int minCnt = Integer.MAX_VALUE;
    
    static boolean isChangeable(String now, String next) {
        int diffCnt = 0;
        
        char[] nowArr = now.toCharArray();
        char[] nextArr = next.toCharArray();
        for (int i = 0; i < now.length(); i++) {
            if (nowArr[i] == nextArr[i]) continue;
            diffCnt++;
            if (diffCnt > 1) return false;
        }
        
        return true;
    }
    
    static void dfs(String now, String target, String[] words, boolean[] visited, int cnt) {
        if (now.equals(target)) {
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            if (!isChangeable(now, words[i])) continue;
            visited[i] = true;
            dfs(words[i], target, words, visited, cnt+1);
            visited[i] = false;
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        boolean isAvailable = false;
        for (String word : words) {
            if (word.equals(target)) {
                isAvailable = true;
                break;
            }
        }
        
        if (!isAvailable) return 0;
        
        dfs(begin, target, words, visited, 0);
        
        return minCnt;
    }
}