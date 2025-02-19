import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] likeList;
    static int[][] seat;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void putStudent(int studentNum) {
        List<Integer> likeStudents = new ArrayList<>();
        for (int x : likeList[studentNum]) {
            likeStudents.add(x);
        }

        // 1번 조건
        // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 자리를 찾자.
        // maxLikeCnt로 좋아하는 학생의 최대 수를 저장하고 비교해서 List에 좌표를 저장할 건데,
        // maxLikeCnt랑 같으면 List에 저장. maxLikeCnt 보다 크다면 List를 싹 다 지우고 새로 좌표 저장
        int maxLikeCnt = 0;
        List<int[]> availableSeat = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (seat[x][y] != 0) continue;

                int nowLikeCnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (likeStudents.contains(seat[nx][ny])) nowLikeCnt++;
                }

                if (maxLikeCnt < nowLikeCnt) {
                    availableSeat.clear();
                    availableSeat.add(new int[]{x, y});
                    maxLikeCnt = nowLikeCnt;
                } else if (maxLikeCnt == nowLikeCnt) {
                    availableSeat.add(new int[]{x, y});
                }
            }
        }

        // 2번 조건
        // availableSeat에서 인접한 비어있는 칸이 가장 많은 자리로 저장
        if (availableSeat.size() == 1) { // 1번 조건에서 하나만 걸리면 그대로 착석 후 반환
            int[] spot = availableSeat.get(0);
            seat[spot[0]][spot[1]] = studentNum;
            return;
        }

        List<int[]> secondAvailableSeat = new ArrayList<>();
        int maxZeroCnt = 0;
        for (int[] spot : availableSeat) {
            int x = spot[0];
            int y = spot[1];

            int nowZeroCnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (seat[nx][ny] == 0) nowZeroCnt++;
            }

            if (maxZeroCnt < nowZeroCnt) {
                secondAvailableSeat.clear();
                secondAvailableSeat.add(new int[]{x, y});
                maxZeroCnt = nowZeroCnt;
            } else if (maxZeroCnt == nowZeroCnt) {
                secondAvailableSeat.add(new int[]{x, y});
            }
        }

        // 3번 조건
        // 행의 번호 (x)와 열의 번호 (y)가 가장 작은 칸으로 설정
        if (secondAvailableSeat.size() == 1) { // 1번 조건에서 하나만 걸리면 그대로 착석 후 반환
            int[] spot = secondAvailableSeat.get(0);
            seat[spot[0]][spot[1]] = studentNum;
            return;
        }

        Collections.sort(secondAvailableSeat, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] spot = secondAvailableSeat.get(0);
        seat[spot[0]][spot[1]] = studentNum;
        return;

    }

    static int getScore() {
        int totalScore = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int nowStudent = seat[x][y];

                List<Integer> likeStudents = new ArrayList<>();
                for (int k : likeList[nowStudent]) {
                    likeStudents.add(k);
                }

                int nowLikeCnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (likeStudents.contains(seat[nx][ny])) nowLikeCnt++;
                }

                if (nowLikeCnt == 0) continue;
                totalScore += Math.pow(10, nowLikeCnt - 1);
            }
        }

        return totalScore;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        likeList = new int[N*N+1][4];
        seat = new int[N][N];
        int[] order = new int[N*N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int studentNum = Integer.parseInt(st.nextToken());
            order[i] = studentNum;
            for (int k = 0; k < 4; k++) {
                likeList[studentNum][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int nowStudent : order) {
            putStudent(nowStudent);
        }

        System.out.println(getScore());   
        
    }
}