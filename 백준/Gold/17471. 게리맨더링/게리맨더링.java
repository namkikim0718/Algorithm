import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] populations;
    static List<List<Integer>> graph = new ArrayList<>();
    static int minDiff = Integer.MAX_VALUE;

    // 모든 경우 찾기
    static void combination(List<Integer> groupA, int start, int size) {
        if (groupA.size() == size) {
            List<Integer> groupB = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (groupA.contains(i)) continue;
                groupB.add(i);
            }

            if (isConnected(groupA) && isConnected(groupB)) {
                calculate(groupA, groupB);
            }

        }

        for (int i = start; i <= N; i++) {
            groupA.add(i);
            combination(groupA, i+1, size);
            groupA.remove(groupA.size() - 1);
        }
    }

    // BFS로 연결되었는지 확인
    static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) return false;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> groupSet = new HashSet<>();
        for (int x : group) {
            groupSet.add(x);
        }
        queue.offer(group.get(0));
        groupSet.remove(group.get(0));

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int x : graph.get(now)) {
                if (groupSet.contains(x)) {
                    queue.offer(x);
                    groupSet.remove(x);
                }
            }
        }

        return groupSet.isEmpty();

    }

    // 차이 계산
    static void calculate(List<Integer> groupA, List<Integer> groupB) {
        int sumA = 0;
        int sumB = 0;
        for (int x : groupA) {
            sumA += populations[x];
        }
        for (int x : groupB) {
            sumB += populations[x];
        }
        minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2개의 구역으로 나눠지는 경우의 수를 모두 찾아서 다 bfs로 돌려서 연결되어있는지 확인
        // 연결되어있으면 각 구역의 인구수를 구해서 계산
        N = Integer.parseInt(br.readLine());
        populations = new int[N+1];
        graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N/2; i++) {
            combination(new ArrayList<>(), 1, i);
        }

        if (minDiff == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        } 
        System.out.println(minDiff);

    }
}