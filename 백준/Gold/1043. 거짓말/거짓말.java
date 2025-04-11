import java.util.*;
import java.io.*;

public class Main {

    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        int truthKnowCnt = Integer.parseInt(st.nextToken());
        Set<Integer> truthKnowSet = new HashSet<>();
        for (int i = 0; i < truthKnowCnt; i++) {
            truthKnowSet.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        List<List<Integer>> partyPeopleList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyPeopleCnt = Integer.parseInt(st.nextToken());
            List<Integer> nowList = new ArrayList<>();

            boolean haveToTellTruth = false;
            for (int k = 0; k < partyPeopleCnt; k++) {
                int now = Integer.parseInt(st.nextToken());
                nowList.add(now);
            }

            partyPeopleList.add(nowList);
        }

        boolean updated = true;
        while (updated) {
            updated = false;

            for (List<Integer> nowList : partyPeopleList) {
                boolean haveToTellTruth = false;
                for (int now : nowList) {
                    if (truthKnowSet.contains(now)) {
                        haveToTellTruth = true;
                        break;
                    }
                }

                if (haveToTellTruth) {
                    for (int x : nowList) {
                        if (truthKnowSet.add(x)) {
                            updated = true;
                        }
                    }
                }
            }
        }

        

        for (List<Integer> nowList : partyPeopleList) {
            boolean haveToTellTruth = false;
            for (int now : nowList) {
                if (truthKnowSet.contains(now)) {
                    haveToTellTruth = true;
                }
            }

            if (!haveToTellTruth) answer++;
        }

        System.out.println(answer);
    }
}
