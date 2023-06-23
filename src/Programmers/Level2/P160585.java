package Programmers.Level2;

public class P160585 {
    public static void main(String[] args) {
        P160585 sol = new P160585();
        int solution = sol.solution(new String[]{"...", "...", "..."});
        System.out.println(solution);
    }

    public int solution(String[] board) {

        int countO = 0, countX = 0;

        char[][] map = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'O') countO++;
                else if(map[i][j] == 'X') countX++;
            }
        }

        // case 1. "O"를 표시할 차례인데 "X"를 표시하거나 반대로 "X"를 표시할 차례인데 "O"를 표시한다.
        if(countO > countX + 1 || countO < countX) return 0;

        // case 2. 선공이나 후공이 승리해서 게임이 종료되었음에도 그 게임을 진행한다.
        String[][] winBoard = {
                {"o..", "o..", "o.."},
                {".o.", ".o.", ".o."},
                {"..o", "..o", "..o"},
                {"ooo", "...", "..."},
                {"...", "ooo", "..."},
                {"...", "...", "ooo"},
                {"o..", ".o.", "..o"},
                {"..o", ".o.", "o.."}
        };

        int oWin = 0;
        int xWin = 0;
        for (String[] curBoard : winBoard) {
            int co = 0, cx = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(curBoard[i].charAt(j) != 'o') continue;

                    if(map[i][j] == 'O') co++;
                    else if(map[i][j] == 'X') cx++;
                }
            }

            if(co == 3 && cx == 0) {
                oWin++;
            } else if (co == 0 && cx == 3){
                xWin++;
            }
        }

        if(oWin == 1 && xWin == 0 && countO <= countX) return 0;
        if(oWin == 0 && xWin == 1 && countO > countX) return 0;
        if(oWin == 2 && xWin == 0 && countO == 5 && countX == 4) return 1; // 33
        if(oWin == 1 && xWin == 0 && countO +1 == countX) return 1;
        if(oWin == 0 && xWin == 1 && countO == countX) return 1;
        if((oWin == 1 && xWin == 0) || (oWin == 0 && xWin == 1) || ((oWin == 0 && xWin == 0))) return 1;
        else return 0;
    }
}
