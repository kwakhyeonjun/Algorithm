package SWEA.D2;

import java.util.Scanner;

public class SWEA1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tset_case = 1; tset_case <= T; tset_case++){
            System.out.printf("#%d\n", tset_case);
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int[][] matrix90;
            int[][] matrix180;
            int[][] matrix270;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            matrix90 = setMatrix90(matrix, N);
            matrix180 = setMatrix90(matrix90, N);
            matrix270 = setMatrix90(matrix180, N);

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.printf("%d", matrix90[i][j]);
                }
                System.out.printf(" ");
                for(int j = 0; j < N; j++){
                    System.out.printf("%d", matrix180[i][j]);
                }
                System.out.printf(" ");
                for(int j = 0; j < N; j++){
                    System.out.printf("%d", matrix270[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static int[][] setMatrix90(int[][] matrix, int N){
        int[][] result = new int[N][N];
        // new matrix index
        for(int i = 0; i < N; i++){
            int n = N - 1;
            for(int j = 0; j < N; j++){
                result[i][j] = matrix[n--][i];
            }
        }
        return result;
    }
}
