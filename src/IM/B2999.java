package IM;

import java.util.Scanner;

public class B2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int N = input.length();
        int R = 0, C = 0;
        for(int i = 1; i <= N; i++){
            if(N%i == 0 && N/i >= i) {
                R = i;
                C = N/R;
            }
        }
        char[][] matrix = new char[R][C];
        int idx = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                matrix[i][j] = input.charAt(idx++);
            }
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
