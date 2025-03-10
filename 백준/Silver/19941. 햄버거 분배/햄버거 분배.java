import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        char[] list = new char[N];
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            list[i] = str.charAt(i);
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (list[i] == 'H' || list[i] == 'X') continue;

            for (int k = -K; k <= K; k++) {
                if (i + k >= 0 && i + k < N && list[i + k] == 'H') {
                    list[i + k] = 'X';
                    cnt++;
                    break;
                }
            }
        }
        
        System.out.println(cnt);
    }
}