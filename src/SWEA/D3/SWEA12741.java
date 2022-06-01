package SWEA.D3;

import java.util.Scanner;

public class SWEA12741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), D = sc.nextInt();
            int answer = 0;
            if(A <= C && B <= D && C <= B) {
                answer = B - C;
            }
            if(C <= A && D <= B && A <= D) {
                answer = D - A;
            }
            if(A < C && D < B) {
                answer = D - C;
            }
            if(C < A && B < D) {
                answer = B - A;
            }
            if(B < C || D < A) answer = 0;
            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
