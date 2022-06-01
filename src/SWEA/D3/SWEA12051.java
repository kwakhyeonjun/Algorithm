package SWEA.D3;

import java.util.Scanner;

public class SWEA12051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(), Pd = sc.nextInt(), Pg = sc.nextInt();
            boolean pos = true;
            //1. 정수로 나타낼 수 있는가?
            int r = 100 / gcd(Pd, 100);
            if(r > N) pos = false;

            if(Pd < 100 && Pg == 100) pos = false;
            if(Pg == 0 && Pd > 0) pos = false;

            System.out.printf("#%d %s\n", t, pos?"Possible":"Broken");

        }
    }

    private static int gcd(int a, int b) {
        while(b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
