import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열의 포인터
        int lt = 0;
        // B 배열의 포인터
        int rt = 0;
        // 합친 배열의 인덱스
        int idx = 0;

        StringBuilder sb = new StringBuilder();

        // 합친 배열의 인덱스가 N+M 보다 크면 중단
        while (idx < N + M) {
            // 각 배열이 인덱스를 넘어가지 않았을 때
            if (lt < N && rt < M) { // 더 작은 값을 가진 배열의 포인터를 1 증가시키고 결과에 추가
                int min = A[lt] > B[rt] ? B[rt++] : A[lt++];
                sb.append(min + " ");
            } else if (rt < M) { // B 배열의 포인터만 인덱스 범위 내 일때
                sb.append(B[rt++] + " ");
            } else if (lt < N) { // A 배열의 포인터만 인덱스 범위 내 일때
                sb.append(A[lt++] + " ");
            }
            idx++;
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}