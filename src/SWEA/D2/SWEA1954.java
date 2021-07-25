package SWEA.D2;

import java.util.Scanner;

public class SWEA1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int x = 0, y = 0, idx = 1;
            int[][] matrix = new int[N][N];
            int mid = N/2;
            while(idx <= N*N) {
                matrix[x][y] = idx;
                if (y >= x) {
                    if (y < N - 1 - x) {
                        if(y + 1 >= N || matrix[x][y+1] != 0) x++;
                        else y++;
                    } else {
                        if(x+1>=N || matrix[x+1][y] != 0) y--;
                        else x++;
                    }
                } else {
                    if (y < N - 1 - x) {
                        if(x-1 < 0 || matrix[x-1][y] != 0) y++;
                        else x--;
                    } else {
                        if(y-1 < 0 || matrix[x][y-1] != 0) x--;
                        else y--;
                    }
                }
                idx++;
            }
            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
