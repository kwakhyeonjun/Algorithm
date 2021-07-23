package SWEA.D2;

import java.util.Scanner;

public class SWEA2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            //input
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }

            //output
            int max = Integer.MIN_VALUE;
            // 1. matrix 탐색
            for(int i = 0; i < N - M + 1; i++){
                for(int j = 0; j < N - M + 1; j++){
                    // 2. 각 셀에서 NxN크기만큼의 파리를 더함함
                    int result = 0;
                    for(int n = 0; n < M; n++){
                        for(int m = 0; m < M; m++){
                            result += matrix[i+n][j+m];
                        }
                    }
                    max = Math.max(max, result);
                }
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}
