package Baekjoon.level08;

import java.util.Scanner;

public class B2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] APT = new int[15][15];
        for(int i = 0; i < 15; i++){
            APT[i][1] = 1;
            APT[0][i] = i;
        }
        for(int i = 1; i <15; i++){
            for(int j = 2; j < 15; j++){
                APT[i][j] = APT[i][j-1] + APT[i-1][j];
            }
        }
        for(int test_case = 1; test_case <= T; test_case++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(APT[k][n]);
        }
    }
}
