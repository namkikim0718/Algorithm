import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] custs = new int[n];
        for (int i = 0; i < n; i++) {
            custs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int leader = Integer.parseInt(st.nextToken());
        int member = Integer.parseInt(st.nextToken());

        long memberCnt = 0;
        for (int cust : custs) {
            cust -= leader;
            if (cust <= 0) continue;
            memberCnt += cust / member;
            if (cust % member != 0) memberCnt++;
        }

        System.out.println(memberCnt + n);

    }
}