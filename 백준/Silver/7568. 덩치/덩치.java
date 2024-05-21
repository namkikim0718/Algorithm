import java.util.*;
import java.io.*;

public class Main {
    static class Student {
        int w;
        int h;
        public Student(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

    public static int[] Solution(Student[] students, int N) {
        int[] rank = new int[N];
        for (int i = 0;i < N; i++) {
            rank[i] = 1;
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (students[i].w > students[j].w && students[i].h > students[j].h) {
                    rank[j]++;
                } else if (students[i].w < students[j].w && students[i].h < students[j].h) {
                    rank[i]++;
                }
            }
        }
        return rank;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            students[i] = new Student(w, h);
        }

        for (int x : Solution(students, N)) {
            bw.write(x + " ");
        }
        bw.flush();
        bw.close();
    }
}