import java.util.*;
import java.io.*;

public class Main {

    static Map<String, String[]> map = new HashMap<>();
    static StringBuilder preResult = new StringBuilder();
    static StringBuilder midResult = new StringBuilder();
    static StringBuilder postResult = new StringBuilder();

    static void pre(String node) {
        preResult.append(node);

        String leftChild = map.get(node)[0];
        String rightChild = map.get(node)[1];

        if (!leftChild.equals(".")) {
            pre(leftChild);
        }
        
        if (!rightChild.equals(".")) {
            pre(rightChild);
        }
    }

    static void mid(String node) {
        String leftChild = map.get(node)[0];
        String rightChild = map.get(node)[1];

        if (!leftChild.equals(".")) {
            mid(leftChild);
        }

        midResult.append(node);
        
        if (!rightChild.equals(".")) {
            mid(rightChild);
        }
    }

    static void post(String node) {
        String leftChild = map.get(node)[0];
        String rightChild = map.get(node)[1];

        if (!leftChild.equals(".")) {
            post(leftChild);
        }
        
        if (!rightChild.equals(".")) {
            post(rightChild);
        }

        postResult.append(node);
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            map.put(parent, new String[]{leftChild, rightChild});
        }

        pre("A");
        mid("A");
        post("A");

        System.out.println(preResult);
        System.out.println(midResult);
        System.out.println(postResult);

    }
}