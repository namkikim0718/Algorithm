import java.util.*;
import java.io.*;

public class Main {


    static long recursion(long A, long B, long C) {
        if (B == 1) return A % C;

        long half = recursion(A, B / 2, C) % C;

        if (B % 2 == 0) {
            return half * half % C;
        } else {
            return A * (half * half % C) % C;
        }
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(recursion(A, B, C));
    }
}