package Baekjoon.level09;

import java.util.Scanner;

/**
 * 1. 두점에서 만나는 경우
 *  - r1 - r2 < d  ||  r1 + r2 > d
 * 2. 한점에서 만나는 경우
 *  - r1 - r2 == d ||  r1 + r2 == d
 * 3. 만나지 않는 경우
 *  - r1 - r2 > d  ||  r1 + r2 < d
 */
public class B1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            double d = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
            int minus = Math.abs(r1 - r2);
            if(x1==x2 && y1==y2 && r1==r2) System.out.println(-1);
            else if(minus > d || r1 + r2 < d) System.out.println(0);
            else if(minus == d || r1 + r2 == d) System.out.println(1);
            else if(minus < d || r1 + r2 > d) System.out.println(2);
        }
    }
}
