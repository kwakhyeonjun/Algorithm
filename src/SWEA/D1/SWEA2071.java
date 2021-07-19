package SWEA.D1;

import java.util.Scanner;

public class SWEA2071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int sum = 0;
            for(int i = 0; i < 10; i++){
                sum += sc.nextInt();
            }
            System.out.printf("#%d %.0f\n", test_case, sum/10.0);
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for(int test_case = 1; test_case <= T; test_case++){
//            double sum = 0;
//            for(int i = 0; i < 10; i++) sum += sc.nextInt();
//            double avg = sum/10;
//            System.out.printf("#%d %.0f\n", test_case, avg);
//        }
//    }
}
