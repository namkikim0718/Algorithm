import java.util.*;

class Solution {
    static int length;
    static int[][] diceList;
    static List<Integer> sumA = new ArrayList<>();
    static List<Integer> sumB = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int[] result;
    
    public void calculate(int[] numA, int[] numB) {
        
        makeSum(0, 0, sumA, numA);
        makeSum(0, 0, sumB, numB);
        
        int winingCnt = 0;
        
        Collections.sort(sumB);
        for (int i = 0; i < sumA.size(); i++) {
            int target = sumA.get(i);
            int start = 0;
            int end = sumB.size() - 1;
            int mid;
            int index = Integer.MIN_VALUE;
            while (start <= end) {
                mid = (start + end) / 2;
                if (sumB.get(mid) < target) {
                    start = mid + 1;
                    index = Math.max(index, mid);
                } else {
                    end = mid - 1;
                }
            }
            if (index != Integer.MIN_VALUE) {
                winingCnt += index + 1;
            }
            
        }
        
        // for(int x : numA) {
        //     System.out.print(x + " ");
        // }
        // System.out.println("winingCnt : " + winingCnt);
        
        if (winingCnt > max) {
            max = winingCnt;
            result = numA;
        }
        
        sumA = new ArrayList<>();
        sumB = new ArrayList<>();
        
    }
    
    public void makeSum(int level, int sum, List<Integer> sumList, int[] numList) {
        
        if (level == length / 2) {
            sumList.add(sum);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            int idx = numList[level];
            makeSum(level + 1, sum + diceList[idx][i], sumList, numList);
        }
    }
    
    public void combination(int level, String A, int cnt){
        
        if (cnt == length / 2) {
            int[] numA = new int[length / 2];
            int[] numB = new int[length / 2];
            
            String[] strA = A.split(" ");
            
            int idx = 0;
            for (int i = 0; i < length; i++) {
                if (!A.contains(String.valueOf(i))) {
                    numB[idx++] = i;
                }
            }
            
            
            for (int i = 0; i < length / 2 ; i++) {
                numA[i] = Integer.parseInt(strA[i]);
            }
            
            calculate(numA, numB);
            return;
        }
        
        for (int i = level; i < length; i++) {
            combination(i + 1, A + i + " ", cnt + 1);
        }
    }
    
    public int[] solution(int[][] dice) {
        diceList = dice;
        length = dice.length;
        
        combination(0, "", 0);
        
        for (int i = 0; i < length / 2; i++) {
            result[i] += 1;
        }
        
        return result;
    }
}