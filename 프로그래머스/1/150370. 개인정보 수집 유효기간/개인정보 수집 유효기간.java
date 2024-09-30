import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        String[] splitToday = today.split("\\.");
        System.out.println(splitToday[0]);
        int nowYear = Integer.parseInt(splitToday[0]);
        int nowMonth = Integer.parseInt(splitToday[1]);
        int nowDay = Integer.parseInt(splitToday[2]);
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] splitPrivacy = privacy.split(" ");
            
            String[] splitDate = splitPrivacy[0].split("\\.");
            String type = splitPrivacy[1];
            
            int year = Integer.parseInt(splitDate[0]);
            int month = Integer.parseInt(splitDate[1]);
            int day = Integer.parseInt(splitDate[2]);
            
            int duration = termMap.get(type);
            
            month += duration;
            if (month > 12) {
                int plusYear = month / 12;
                month -= plusYear * 12;
                if (month == 0){
                    month = 12;
                    year += plusYear - 1;
                } else {
                    year += plusYear;
                }
                
            }

                
            
            if (day == 1) {
                month--;
                day = 28;
            } else {
                day -= 1;
            }
            
            if (nowYear == year) {
                if (nowMonth > month) {
                    answer.add(i+1);
                }  else if (nowMonth == month) {
                    if (nowDay > day) {
                        answer.add(i+1);
                    }
                }
            } else if (nowYear > year) {
                answer.add(i+1);
            }
        }
        
        
        return answer;
    }
}