package SWEA.D1;

import java.util.Scanner;

public class SWEA206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            String date = sc.next();
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));
            boolean isDate = true;
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(day > 31 || day < 1) isDate = false;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(day > 30 || day < 1) isDate = false;
                    break;
                case 2:
                    if(day > 28 || day < 1) isDate = false;
                    break;
                default:
                    isDate = false;
                    break;
            }
            if(isDate)
                System.out.printf("#%d %04d/%02d/%02d\n", test_case, year, month, day);
            else System.out.printf("#%d -1\n", test_case);
        }
    }
}
