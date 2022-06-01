package SWEA.D3;

import java.util.Scanner;

public class SWEA12368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int A = sc.nextInt(), B = sc.nextInt();
            System.out.printf("#%d %d\n", t, (B+A)%24);
        }
    }
}
