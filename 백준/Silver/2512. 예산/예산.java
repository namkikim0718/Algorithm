import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
    
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
    
        Arrays.sort(nums);
        
        // 누적합을 쓰는 문제가 아니다!
        // 정렬된 상태에서 특정값을 찾는 로직이므로 이진탐색을 떠올려야한다.
        
        int left = 0;
        int right = nums[N-1];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int num : nums) {
                sum += Math.min(num, mid);
            }

            if (sum <= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}