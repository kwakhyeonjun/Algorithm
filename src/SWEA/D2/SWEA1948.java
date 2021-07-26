package SWEA.D2;

import java.util.Scanner;

public class SWEA1948 {
    public static void main(String[] args) {
        int[] dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int month1 = sc.nextInt() - 1;
            int day1 = sc.nextInt();
            int month2 = sc.nextInt() - 1;
            int day2 = sc.nextInt();
            int count = 0;
            for(int i =  month1 + 1; i < month2; i++){
                count += dates[i];
            }
            if(month1 == month2) count = day2 - day1 + 1;
            else{
                count += dates[month1] - day1 + 1;
                count += day2;
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}
