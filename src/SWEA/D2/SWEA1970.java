package SWEA.D2;

import java.util.Scanner;

public class SWEA1970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int[] count = new int[8];
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            for(int i = 0; i < moneys.length; i++){
                int eachCount = N / moneys[i];
                count[i] = eachCount;
                N -= moneys[i] * eachCount;
            }
            System.out.printf("#%d\n", test_case);
            for(int i = 0; i < count.length; i++){
                System.out.printf("%d ", count[i]);
            }
            System.out.println();
        }
    }
}
