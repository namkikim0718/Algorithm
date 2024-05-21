import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String mode = st.nextToken();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        if (mode.equals("Y")) {
            bw.write(set.size() + "\n");
        } else if (mode.equals("F")) {
            bw.write(set.size() / 2 + "\n");
        } else if (mode.equals("O")) {
            bw.write(set.size() / 3 + "\n");
        }

        bw.flush();
        bw.close();
    }
}