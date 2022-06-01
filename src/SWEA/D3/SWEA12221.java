package SWEA.D3;

import java.util.Scanner;

public class SWEA12221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int A = sc.nextInt(), B = sc.nextInt(), answer = A * B;
            if(A > 9 || B > 9) answer = -1;
            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
