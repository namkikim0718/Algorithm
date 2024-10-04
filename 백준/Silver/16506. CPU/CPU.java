import java.util.*;
import java.io.*;

public class Main {

    static String transferOpcode(String opcode) {
        switch (opcode) {
            case "ADD" :
                return "000000";
            case "ADDC" :
                return "000010";
            case "SUB" :
                return "000100";
            case "SUBC" :
                return "000110";
            case "MOV" :
                return "001000";
            case "MOVC" :
                return "001010";
            case "AND" :
                return "001100";
            case "ANDC" :
                return "001110";
            case "OR" :
                return "010000";
            case "ORC" :
                return "010010";
            case "NOT" :
                return "010100";
            case "MULT" :
                return "011000";
            case "MULTC" :
                return "011010";
            case "LSFTL" :
                return "011100";
            case "LSFTLC" :
                return "011110";
            case "LSFTR" :
                return "100000";
            case "LSFTRC" :
                return "100010";
            case "ASFTR" :
                return "100100";
            case "ASFTRC" :
                return "100110";
            case "RL" :
                return "101000";
            case "RLC" :
                return "101010";
            case "RR" :
                return "101100";
            case "RRC" :
                return "101110";
            default :

        }
        return "";
    }

    static String transferRD(int rD) {
        String str = Integer.toBinaryString(rD);
        String output = "";
        for (int i = 0; i < 3 - str.length(); i++) {
            output += "0";
        }
        return output + str;
    }

    static String transferRA(String result, int rA) {
        if (result.substring(0, 4).equals("0010") || result.substring(0, 4).equals("0101")) {
            return "000";
        }
        String str = Integer.toBinaryString(rA);

        String output = "";
        for (int i = 0; i < 3 - str.length(); i++) {
            output += "0";
        }

        return output + str;
    }

    static String transferRB(String result, int rB) {
        String str = Integer.toBinaryString(rB);
        String output = "";

        if (result.charAt(4) == '1') {
            for (int i = 0; i < 4 - str.length(); i++) {
                output += "0";
            }
            return output + str;
        }

        for (int i = 0; i < 3 - str.length(); i++) {
            output += "0";
        }
        return output + str + "0";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opcode = st.nextToken();
            int rD = Integer.parseInt(st.nextToken());
            int rA = Integer.parseInt(st.nextToken());
            int rB = Integer.parseInt(st.nextToken());

            String result = "";
            result += transferOpcode(opcode);
            result += transferRD(rD);
            result += transferRA(result, rA);
            result += transferRB(result, rB);

            sb.append(result + "\n");
        }

        System.out.println(sb.toString().trim() + "\n");

    }
}