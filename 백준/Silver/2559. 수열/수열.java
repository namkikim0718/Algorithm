import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] tempList = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tempList[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = K - 1;
        int sum = 0;
        // 첫번째 블록 계산
        for (int i = left; i <= right; i++) {
            sum += tempList[i];
        }

        int max = sum;
        while(right < N - 1) {
            sum -= tempList[left++];
            sum += tempList[++right];
            max = Math.max(max, sum);
        }


        System.out.println(max);
    }
}