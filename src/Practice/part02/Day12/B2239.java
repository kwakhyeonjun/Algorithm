package Practice.part02.Day12;

import java.io.*;

public class B2239 {

    private static int[][] sudoku;
    private static boolean[][][] nums;

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

        nums = new boolean[9][9][10];

        while(!isAll()){

            setLine();
            setBox();

        }
    }

    private static boolean[][] col;
    private static boolean[][] row;
    private static boolean[][][] box;

    private static void setBox() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = 3 * i;
                int y = 3 * j;

                for (int k = x; k < x + 3; k++) {
                    for (int l = y; l < y + 3; l++) {
                        box[i][j][sudoku[k][l]] = true;
                    }
                }
            }
        }
    }

    private static void setLine() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                col[i][sudoku[i][j]] = true;
                row[i][sudoku[j][i]] = true;
            }
        }
    }

    private static void search(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoku[i][j] == 0){

                    boolean[] cur = new boolean[10];
                    for (int k = 1; k <= 9; k++) {
                        if(col[i][k]) cur[k] = true;
                        if(row[i][k]) cur[k] = true;
                    }


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
