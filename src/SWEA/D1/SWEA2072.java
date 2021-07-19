package SWEA.D1;

import java.util.Scanner;

public class SWEA2072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int T = 1; T <= test_case; T++){
            int sum = 0;
            for(int i = 0; i < 10; i++){
                int input = sc.nextInt();
                if(input%2 == 1) sum += input;
            }
            System.out.printf("#%d %d\n", T, sum);
        }
    }
}
