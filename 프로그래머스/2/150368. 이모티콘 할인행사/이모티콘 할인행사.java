import java.util.*;

class Solution {
    
    static int maxCnt = 0;
    static int maxPriceSum = 0;
    
    static int emoticonCnt;
    static int userCnt;
    // 할인율 경우의 수
    
    public static void findCases(int level, int[] dc, int[][] users, int[] emoticons) {
        if (level == emoticonCnt) {
            check(dc, users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            dc[level] = i;
            findCases(level + 1, dc, users, emoticons);
        }
    }
    
    public static void check(int[] dc, int[][] users, int[] emoticons) {
        
        int nowCnt = 0;
        int nowPriceSum = 0;
        int[] sumList = new int[userCnt];
            
        for (int k = 0; k < userCnt; k++) {
            int[] user = users[k];
            int minRatio = user[0];
            int minPrice = user[1];
                
                
            for (int j = 0; j < dc.length; j++) {
                int nowRatio = dc[j];
                int nowPrice = emoticons[j] * (100 - nowRatio) / 100;
                    
                if (nowRatio < minRatio) continue;
                    
                sumList[k] += nowPrice;
            }
        }
            
        for (int k = 0; k < userCnt; k++) {
            if (sumList[k] >= users[k][1]) {
                nowCnt++;
            } else {
                nowPriceSum += sumList[k];
            }
        }
        if (maxCnt < nowCnt) {
            maxCnt = nowCnt;
            maxPriceSum = nowPriceSum;
        } else if (maxCnt == nowCnt && maxPriceSum < nowPriceSum) {
            maxPriceSum = nowPriceSum;
        }
    }
    
    
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        userCnt = users.length;
        emoticonCnt = emoticons.length;

        findCases(0, new int[emoticonCnt], users, emoticons);
    
        answer[0] = maxCnt;
        answer[1] = maxPriceSum;
        
        return answer;
    }
}