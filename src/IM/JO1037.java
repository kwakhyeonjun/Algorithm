package IM;

import java.util.Scanner;

public class JO1037 {
    private static int cx, cy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n ;i++){
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        if(isParity(matrix) == 0) System.out.println("OK");
        else if(isParity(matrix) == 1)System.out.println("Change bit (" + (cx+1) + "," + (cy+1) + ")");
        else System.out.println("Corrupt");

    }

    private static int isParity(int[][] matrix){
        int n = matrix.length;
        int calN = 0, rowN = 0;
        for(int i = 0; i < n; i++){
            int cal = 0;
            for(int j = 0; j < n; j++){
                cal += matrix[i][j];
            }
            if(cal%2 != 0) {
                calN++;
                cx = i;
            }
        }
        for(int i = 0; i < n; i++){
            int row = 0;
            for(int j = 0; j < n; j++){
                row += matrix[j][i];
            }
            if(row%2 != 0) {
                rowN++;
                cy = i;
            }
        }
        if(calN == 0 && rowN == 0) return 0;
        else if(calN == 1 && rowN == 1) return 1;
        else return 2;
    }
}
