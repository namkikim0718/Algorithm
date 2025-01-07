import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] blocks = new int[W];
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] graph = new boolean[H][W];
        for (int i = 0; i < W; i++) {
            for (int j = blocks[i]; j > 0; j--) {
                graph[H-j][i] = true;
            }
        }

        int total = 0;
        for (int i = 0; i < H; i++) {
            boolean isLeftBlock = false;
            int saveWater = 0;
            for (int j = 0; j < W; j++) {
                if (!isLeftBlock && graph[i][j]) {
                    isLeftBlock = true;
                }
                if (isLeftBlock) {
                    if (graph[i][j]) {
                        total += saveWater;
                        saveWater = 0;
                        continue;
                    }
                    saveWater++;
                }
            }
        }
        System.out.println(total);
    }
}