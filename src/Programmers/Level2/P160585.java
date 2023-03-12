package Programmers.Level2;

public class P160585 {
    public static void main(String[] args) {
        P160585 sol = new P160585();
        int solution = sol.solution(new String[]{"O.X", ".O.", "..X"});
        System.out.println(solution);
    }

    public int solution(String[] board) {

        boolean oWin = false, xWin = false;
        int oCount = 0, xCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'O') oCount++;
                if(board[i].charAt(j) == 'X') xCount++;
            }
        }
        if(oCount < xCount || oCount - xCount > 1) return 0;

        for (int i = 0; i < 3; i++) {
            // 가로 확인
            if(isRow(board, i)) {
                if(board[i].charAt(0) == 'O') {
                    oWin = true;
                } else if(board[i].charAt(0) == 'X') {
                    xWin = true;
                }
            }
            // 세로 확인
            if(isCol(board, i)) {
                if(board[i].charAt(0) == 'O') {
                    oWin = true;
                } else if(board[i].charAt(0) == 'X') {
                    xWin = true;
                }
            }
        }

        // 대각선 확인
        if(isCross1(board)) {
            if(board[0].charAt(0) == 'O') {
                oWin = true;
            } else if(board[0].charAt(0) == 'X') {
                xWin = true;
            }
        }

        if(isCross2(board)) {
            if(board[0].charAt(2) == 'O') {
                oWin = true;
            } else if(board[0].charAt(2) == 'X') {
                xWin = true;
            }
        }

        if(oWin && oCount - 1 != xCount) return 0;
        if(xWin && oCount != xCount) return 0;
        if(oWin && xWin) return 0;

        return 1;
    }

    private boolean isCross2(String[] board) {
        for (int i = 0; i < 3; i++) {
            if(board[i].charAt(2 - i) != board[2].charAt(0)) return false;
        }
        return true;
    }

    private boolean isCross1(String[] board) {
        for (int i = 0; i < 3; i++) {
            if(board[i].charAt(i) != board[0].charAt(0)) return false;
        }
        return true;
    }

    private boolean isCol(String[] board, int y) {
        for (int i = 0; i < 3; i++) {
            if(board[i].charAt(y) != board[0].charAt(y)) return false;
        }
        return true;
    }

    private boolean isRow(String[] board, int x) {
        for (int j = 0; j < 3; j++) {
            if(board[x].charAt(j) != board[x].charAt(0)) return false;
        }
        return true;
    }

    private static final int[][][] done = {
            {{0, 0}, {0, 1}, {0, 2}},
            {{0, 0}, {1, 0}, {2, 0}},
            {{0, 0}, {1, 1}, {2, 2}},
            {{0, 0}, {1, -1}, {2, -2}}
    };
}
