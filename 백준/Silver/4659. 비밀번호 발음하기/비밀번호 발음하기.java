import java.util.*;
import java.io.*;

public class Main {

    static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
    
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String str = br.readLine();

            if (str.equals("end")) break;


            if (!str.contains("a") && !str.contains("e") && !str.contains("i") && !str.contains("o") && !str.contains("u")) {
                sb.append("<").append(str).append("> is not acceptable.\n");
                continue;
            }

            boolean check2 = true;
            if (str.length() >= 3) {
                for (int i = 1; i < str.length() - 1; i++) {
                    boolean vowelCheck1 = isVowel(str.charAt(i - 1));
                    boolean vowelCheck2 = isVowel(str.charAt(i));
                    boolean vowelCheck3 = isVowel(str.charAt(i + 1));
                    if (vowelCheck1 == vowelCheck2 && vowelCheck2 == vowelCheck3) {
                        sb.append("<").append(str).append("> is not acceptable.\n");
                        check2 = false;
                        break;
                    }
                }
            }

            boolean check3 = true;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) == str.charAt(i)) {
                    if (str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'o') {
                        sb.append("<").append(str).append("> is not acceptable.\n");
                        check3 = false;
                        break;
                    }
                }
            }

            if (check2 && check3) {
                sb.append("<").append(str).append("> is acceptable.\n");
            }
        }

        System.out.println(sb);
    }
}