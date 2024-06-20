import java.util.*;

class Solution {
    static ArrayList<int[]> arr = new ArrayList<>();
    
    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 0) {
            return;
        } else {
            hanoi(n-1, start, end, mid);
            arr.add(new int[]{start, end});
            System.out.print(start + ", "+ end + "\n");
            hanoi(n-1, mid, start, end);
        }
    }
    
    public ArrayList<int[]> solution(int n) {
        
        hanoi(n, 1, 2, 3);
        
        return arr;
    }
}