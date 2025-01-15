import java.util.*;
import java.io.*;

public class Main {


    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() < M) continue;

            map.put(input, map.getOrDefault(input, 0) + 1);
            if (map.get(input) > 1) continue;
            words.add(input);
        }

        words.sort((word1, word2) -> {
            int frequency = map.get(word2) - map.get(word1);
            if (frequency != 0) return frequency;

            int length = word2.length() - word1.length();
            if (length != 0) return length;

            return word1.compareTo(word2);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word + "\n");
        }

        System.out.println(sb.toString().trim());
    }
}