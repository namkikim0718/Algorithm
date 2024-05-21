import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int mod = N % 4;

        if (mod == 1 || mod == 3) {
            bw.write("SK" + "\n");
        } else {
            bw.write("CY" + "\n");
        }
        bw.flush();
        bw.close();

    }
}