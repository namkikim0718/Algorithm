import java.util.*;
import java.io.*;

public class Main {

    static boolean binarySearch(List<String> peopleList, String target) {
        int left = 0;
        int right = peopleList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (peopleList.get(mid).equals(target)) return true;

            if (peopleList.get(mid).compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<String> peopleList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            peopleList.add(br.readLine());
        }
        Collections.sort(peopleList, (a, b) -> {
            return a.compareTo(b);
        });

        List<String> peopleList2 = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            peopleList2.add(br.readLine());
        }
        Collections.sort(peopleList2, (a, b) -> {
            return a.compareTo(b);
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (binarySearch(peopleList, peopleList2.get(i))) {
                result.add(peopleList2.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
