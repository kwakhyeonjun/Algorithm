package SWEA.D2;

import java.util.Scanner;

public class SWEA1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int result = 0;
            for(int i = 1; i <= N; i++){
                if(i%2!=0)  result += i;
                else result -= i;
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
