import java.util.*;

class Solution {
    public int solution(String[] words) {
        
        // 모든 단어를 알파벳순으로 정렬해서 앞에꺼랑 겹치는 부분을 찾고 비교
        // aab, aac, aad, aae 이면 aab는 뒤에꺼인 aac와 aa만 겹치니까 2 + 1번 입력하면 검색가능
        // 근데 aa, aab 이면 aa가 겹치는데 겹치는 부분이 앞의꺼 전부니까 2번만 입력하면 검색가능
        Arrays.sort(words, (a, b) -> {
           return a.compareTo(b);
        });
        
        int[] cnt = new int[words.length];
        
        for (int i = 0; i < words.length; i++) {
            String now = words[i];
            int beforeSameCnt = 0;
            int afterSameCnt = 0;
            
            // 앞에꺼 있으면 앞에것도 비교
            if (i - 1 >= 0) {
                String before = words[i-1];
                
                for (int k = 0; k < before.length(); k++) {
                    if (before.charAt(k) != now.charAt(k)) break;
                    beforeSameCnt++;
                }
            }
            
            // 뒤에꺼 있으면 뒤에것도 비교
            if (i + 1 < words.length) {
                String after = words[i+1];
                
                for (int k = 0; k < now.length(); k++) {
                    if (now.charAt(k) != after.charAt(k)) break;
                    afterSameCnt++;
                }
            }
           
            
            // 겹치는거 없으면 한글자 입력하면 됨
            int maxSameCnt = Math.max(afterSameCnt, beforeSameCnt);
            if (maxSameCnt == 0) {
                cnt[i] = 1;
            } else { // 겹치는 글자 길이가 현재 단어 길이랑 같으면 그 길이만큼 입력, 다르면 maxSameCnt+1
                if (maxSameCnt == now.length()) {
                    cnt[i] = maxSameCnt;
                } else {
                    cnt[i] = maxSameCnt + 1;
                }
            }
        }
        
        int sum = 0;
        for (int x : cnt) {
            sum += x;
        }
        
        return sum;
    }
}