import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            map.put(String.valueOf(i), input);
            map.put(input, String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            sb.append(map.get(target)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
