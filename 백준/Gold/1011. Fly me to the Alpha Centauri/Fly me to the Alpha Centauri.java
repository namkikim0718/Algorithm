import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
    
        int T = Integer.parseInt(br.readLine());
    
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int dist = y - x;
            int max = (int) Math.sqrt(dist);
            int cnt = 0;
            
            if (dist == max * max) {
               cnt = max * 2 - 1;
               sb.append(cnt + "\n");
               continue;
            }
            
            if (dist <= max * max + max) {
                cnt = max * 2;
            } else {
                cnt = max * 2 + 1;
            }
            
            
            sb.append(cnt + "\n");
        }
    
        System.out.println(sb.toString());

    
    }
}