import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N * N * M = 1,000,000,000
        // 각 반에서 한명씩 뽑아서 차이 계산해서 최소이면 갈아끼우고,
        // 뽑은 N명 중에서 최소인 학생을 다음학생으로 이동 (정렬 시킨 상태에서)
        int[][] students = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] student : students) {
            Arrays.sort(student);
        }

        int[] selectedIdx = new int[N];
        int minDiff = Integer.MAX_VALUE;
        while (true) {

            boolean isDone = false;
            for (int x : selectedIdx) {
                if (x >= M) {
                    isDone = true;
                }
            }
            if (isDone) break;

            // 최소/최대 찾기
            int[] minStudent = {-1, Integer.MAX_VALUE};
            int[] maxStudent = {-1, Integer.MIN_VALUE};

            for (int i = 0; i < N; i++) {
                int nowIdx = selectedIdx[i];
                int nowStat = students[i][nowIdx];

                // 최소 찾기
                if (minStudent[1] > nowStat) {
                    minStudent[0] = i;
                    minStudent[1] = nowStat;
                }
                // 최대 찾기
                if (maxStudent[1] < nowStat) {
                    maxStudent[0] = i;
                    maxStudent[1] = nowStat;
                }
            }
            minDiff = Math.min(minDiff, maxStudent[1] - minStudent[1]);

            selectedIdx[minStudent[0]]++;
        }

        System.out.println(minDiff);
    }
}