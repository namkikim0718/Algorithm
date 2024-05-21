import java.util.*;
import java.io.*;

public class Main {
    public static int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] fullArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    public static int[] zeroArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void add(int num) {
        if (arr[num] == 0) {
            arr[num] = num;
        }
    }

    public static void remove(int num) {
        if (arr[num] != 0) {
            arr[num] = 0;
        }
    }

    public static int check(int num) {
        if (arr[num] == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void toggle(int num) {
        if (arr[num] != 0) {
            arr[num] = 0;
        } else {
            arr[num] = num;
        }
    }

    public static void all() {
        arr = Arrays.copyOf(fullArr, 21);
    }

    public static void empty() {
        arr = Arrays.copyOf(zeroArr, 21);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        int M = Integer.parseInt(str);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String mode = st.nextToken();
            int num = 0;
            if (!mode.equals("all") && !mode.equals("empty")) {
                num = Integer.parseInt(st.nextToken());
            }

            if (mode.equals("add")) {
                add(num);
            } else if (mode.equals("remove")) {
                remove(num);
            } else if (mode.equals("check")) {
                sb.append(check(num) + "\n");
            } else if (mode.equals("toggle")) {
                toggle(num);
            } else if (mode.equals("all")) {
                all();
            } else if (mode.equals("empty")) {
                empty();
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}