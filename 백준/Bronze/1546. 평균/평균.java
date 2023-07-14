import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();
        String strScore = sc.nextLine();
        String[] splitScores = strScore.split(" ");
        double[] scores = new double[num];
        for(int i = 0; i<num; i++) {
            scores[i] = Double.parseDouble(splitScores[i]);

        }

        double max = 0;
        for(int i = 0; i < num; i++) {
            if(max < scores[i]) max = scores[i];
        }
        double sum = 0;
        for (int i = 0; i < num; i++) {
            scores[i] = scores[i]/max*100;
            sum += scores[i];
        }
        double avg = sum/num;
        System.out.printf("%.6f", avg);
    }
}