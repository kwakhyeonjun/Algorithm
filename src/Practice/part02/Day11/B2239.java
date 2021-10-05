package Practice.part02.Day11;

import java.io.*;
import java.util.StringTokenizer;

public class B2239 {

    private static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String cur = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = cur.charAt(j) - '0';
            }
        }

        boolean[][][] nums = new boolean[9][9][10];

        while(!isAll()){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(sudoku[i][j] != 0) continue;

                    for (int k = 0; k < 9; k++) {
                        nums[i][j][sudoku[i][k]] = true;
                        nums[i][j][sudoku[k][j]] = true;
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                }
            }

        }
    }

    private static boolean isAll(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoku[i][j] == 0) return false;
            }
        }
        return true;
    }
}
