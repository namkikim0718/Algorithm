import java.util.*;

class Solution {
    public int solution(String skill, String[] skillTrees) {
        int answer = 0;
        
        for (int i = 0; i < skillTrees.length; i++) {
            String tmp = "";
            for (int j = 0; j < skillTrees[i].length(); j++) {
                if (skill.contains(String.valueOf(skillTrees[i].charAt(j)))) {
                    tmp += skillTrees[i].charAt(j);
                }
            }
            
            if (tmp.length() != 0){
                boolean isPossible = true;
                for (int k = 0; k < tmp.length(); k++) {
                    if (tmp.charAt(k) != skill.charAt(k)) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    answer++;
                }
            } else {
                answer++;
            }
            
        }
        
        
        
        
        return answer;
    }
}