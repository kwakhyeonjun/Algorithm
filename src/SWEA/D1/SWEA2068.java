package SWEA.D1;

import java.util.Scanner;

public class SWEA2068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int max = sc.nextInt();
            for(int i = 0; i < 9; i++){
                int temp = sc.nextInt();
                if(max < temp) max = temp;
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}
