import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static String[] powerStr;
    static int[] powerNum;

    public static String powerCheck(int myPower) {
        int left = 0;
        int right = N - 1;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (myPower == powerNum[mid]) {
                break;
            }
            else if (myPower > powerNum[mid]) {
                left = mid + 1;
            } else if (myPower < powerNum[mid]) {
                if (mid > 0 && myPower > powerNum[mid-1]) {
                    return powerStr[mid];
                }
                right = mid - 1;
            }
        }

        return powerStr[mid];
    }

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        powerStr = new String[N];
        powerNum = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String nowStr = st.nextToken();
            int nowNum = Integer.parseInt(st.nextToken());
            if (i != 0 && powerNum[i-1] == nowNum) {
                i--;
                N--;
                continue;
            }
            powerStr[i] = nowStr;
            powerNum[i] = nowNum;
        }

        // 10,000,000,000 이 넘어가는데, 이분 탐색은 어떨까. .
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int myPower = Integer.parseInt(br.readLine());
            sb.append(powerCheck(myPower) + "\n");
        }

        System.out.println(sb.toString().trim());

    }
}