import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> group1 = new ArrayList<>();
        ArrayList<String> group2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i+2);
            boolean isAvailable = true;
            for (char c : tmp.toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    isAvailable = false;
                }
            }
            if (isAvailable) {
                group1.add(tmp);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i+2);
            boolean isAvailable = true;
            for (char c : tmp.toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    isAvailable = false;
                }
            }
            if (isAvailable) {
                group2.add(tmp);
            }
        }
        
        for (String s : group1) {
            System.out.print(s + ", ");
        }
        System.out.println();
        for (String s : group2) {
            System.out.print(s + ", ");
        }
        System.out.println();
        
        if (group1.size() == 0 && group2.size() == 0) {
            return 65536;
        }
        
        double sameCnt = 0;
        if (group1.size() < group2.size()) {
            for (int p = 0; p < group1.size(); p++) {
                String s1 = group1.get(p);
                for(int q = 0; q < group2.size(); q++) {
                    String s2 = group2.get(q);
                    if (s1.equals(s2)) {
                        group2.set(q, "  ");
                        sameCnt++;
                        break;
                    }
                }
            }
        } else {
            for (int q = 0; q < group2.size(); q++) {
                String s2 = group2.get(q);
                for(int p = 0; p < group1.size(); p++) {
                    String s1 = group1.get(p);
                    if (s2.equals(s1)) {
                        group1.set(p, "  ");
                        sameCnt++;
                        break;
                    }
                }
            }
        }
        
        
        double totalCnt = group1.size() + group2.size() - sameCnt;
        answer = (int)(sameCnt / totalCnt * 65536);
        
        return answer;
    }
}