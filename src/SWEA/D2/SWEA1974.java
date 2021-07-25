package SWEA.D2;

import java.util.Scanner;

public class SWEA1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            // input
            int[][] sudoku = new int[9][9];
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sudoku[i][j] = sc.nextInt();
                }
            }

            // output
            int[] checkNum1 = new int[9];
            int[] checkNum2 = new int[9];
            boolean isSudoku = true;
            tot:
            for(int i = 0; i < 9; i++){
                // 1. 가로에 중복된 숫자 확인
                for(int j = 0; j < 9; j++){
                    if(checkNum1[sudoku[i][j] - 1] != 0){
                        isSudoku = false;
                        break tot;
                    }
                    checkNum1[sudoku[i][j] - 1] = 1;
                    // 2. 세로에 중복된 숫자 확인
                    if (checkNum2[sudoku[j][i] - 1] != 0) {
                        isSudoku = false;
                        break tot;
                    }
                    checkNum2[sudoku[j][i] - 1] = 1;
                }
                for(int k = 0; k < 9; k++){
                    checkNum1[k] = 0;
                    checkNum2[k] = 0;
                }
            }
            for(int i = 0; i < 9; i++){
                checkNum1[i] = 0;
            }
            // 3. 3x3에서 중복된 숫자 확인
            tot2:
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    for(int k = 0; k < 3; k++){
                        for(int l = 0; l < 3; l++){
                            if(checkNum1[sudoku[3 * i + k][3 * j + l] - 1] != 0) {
                                isSudoku = false;
                                break tot2;
                            }
                            checkNum1[sudoku[3 * i + k][3 * j + l] - 1] = 1;
                        }
                    }
                    for(int z = 0; z < 9; z++){
                        checkNum1[z] = 0;
                    }
                }
            }
            if(isSudoku) System.out.printf("#%d %d\n", test_case, 1);
            else System.out.printf("#%d %d\n", test_case, 0);
        }
    }
}
