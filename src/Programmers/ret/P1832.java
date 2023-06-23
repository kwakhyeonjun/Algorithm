package Programmers.ret;

import java.util.LinkedList;
import java.util.Queue;

public class P1832 {
    int MOD = 20170805;

    /**
     * 0: 통행
     * 1: 통행 금지
     * 2: 직진만 가능
     */
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        // board[i][j][0] = 왼쪽
        // board[i][j][1] = 위
        int[][][] board = new int[m][n][2];

        for(int i = 1; i < m; i++) {
            if(cityMap[i][0] == 1) break;
            board[i][0][1] = 1;
        }

        for(int i = 1; i < n; i++) {
            if(cityMap[0][i] == 1) break;
            board[0][i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(cityMap[i][j] == 1) continue;
                //왼쪽 확인
                if(cityMap[i][j - 1] == 2) {
                    board[i][j][0] = board[i][j - 1][0];
                } else {
                    board[i][j][0] = (board[i][j - 1][0] + board[i][j - 1][1]) % MOD;
                }

                if(cityMap[i - 1][j] == 2) {
                    board[i][j][1] = board[i - 1][j][1];
                } else {
                    board[i][j][1] = (board[i - 1][j][0] + board[i - 1][j][1]) % MOD;
                }
            }
        }

        return board[m - 1][n - 1][0] + board[m - 1][n - 1][1];
    }
}
