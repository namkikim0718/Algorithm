class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int aNum = (int) 'A';
        int zNum = (int) 'Z';
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            int now = (int)name.charAt(i);
            answer += Math.min(now - aNum, zNum - now + 1);
            
            int endA = i + 1;
            while (endA < name.length() && name.charAt(endA) == 'A') {
                endA++;
            }
        
            move = Math.min(move, i * 2 + (name.length() - endA));
            move = Math.min(move, (name.length() - endA) * 2 + i);
        }
 
        return answer + move;
    }
}