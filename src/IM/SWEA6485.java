package IM;

import java.util.Scanner;

public class SWEA6485 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int[] stop = new int[5001];
            for(int i = 0; i < N; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                for(int j = a; j <= b; j++){
                    stop[j]++;
                }
            }
            int P = sc.nextInt();
            System.out.print("#" + test_case +" ");
            for(int i = 0; i < P; i++){
                int c = sc.nextInt();
                System.out.print(stop[c] + " ");
            }
            System.out.println();
        }
    }
}
