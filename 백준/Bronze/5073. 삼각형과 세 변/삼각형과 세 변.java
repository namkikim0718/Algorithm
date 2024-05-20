import java.util.*;

public class Main {

    public static String Solution(int[] triangle) {
        Arrays.sort(triangle);
        
        if (triangle[0] + triangle[1] > triangle[2]) {
            if (triangle[0] == triangle[1] || triangle[0] == triangle[2] || triangle[1] == triangle[2]) {
                if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
                    return "Equilateral";
                } else {
                    return "Isosceles";
                }
            } else {
                return "Scalene";
            }
        } else {
            return "Invalid";
        }
        
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while(true) {
            int[] triangle = new int[3];
            triangle[0] = kb.nextInt();
            triangle[1] = kb.nextInt();
            triangle[2] = kb.nextInt();

            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
                return;
            } else {
                System.out.println(Solution(triangle));
            }
        }
        
    }
}