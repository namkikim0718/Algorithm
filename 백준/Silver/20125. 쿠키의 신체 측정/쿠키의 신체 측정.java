import java.util.*;
import java.io.*;

public class Main {

    public static int[] Solution(int[][] graph, int N) {
        int[] heart = new int[2];
        int[] answer = new int[5];

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(graph[i][j-1] == 1 && graph[i][j+1] == 1 && graph[i-1][j]==1 && graph[i+1][j]==1) {
                    heart[0] = i;
                    heart[1] = j;
                    break;
                }
            }
        }

        System.out.print(heart[0]+1 + " ");
        System.out.println(heart[1]+1);
        
        int x = heart[0];
        int y = heart[1]-1;

        while(graph[x][y] == 1) {
            y--;
            answer[0]++;
            if (y < 0) break;
        }

        x = heart[0];
        y = heart[1]+1;
        while(graph[x][y] == 1) {
            y++;
            answer[1]++;
            if (y >= N) break;
        }
        x = heart[0]+1;
        y = heart[1];
        while(graph[x][y] == 1) {
            x++;
            answer[2]++;
            if (x >= N) break;
        }
        int centerX = x;
        int centerY = y;

        y -= 1;
        while(graph[x][y] == 1) {
            x++;
            answer[3]++;
            if (x >= N) break;
        }
        x = centerX;
        y = centerY + 1;
        while(graph[x][y] == 1) {
            x++;
            answer[4]++;
            if (x >= N) break;
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int[] head = new int[2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char tmp = str.charAt(j);
                if (tmp == '_') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : Solution(graph, N)) {
            sb.append(x + " ");
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}