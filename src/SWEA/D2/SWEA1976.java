package SWEA.D2;

import java.util.Scanner;

public class SWEA1976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int hour1 = sc.nextInt();
            int min1 = sc.nextInt();
            int hour2 = sc.nextInt();
            int min2 = sc.nextInt();

            int nMin = min1 + min2;
            if(nMin >= 60){
                nMin -= 60;
                hour1++;
            }
            int nHour = hour1 + hour2;
            if(nHour > 12){
                nHour -= 12;
            }
            System.out.printf("#%d %d %d\n", test_case, nHour, nMin);
        }
    }
}
