package Programmers.ret;

public class P12905 {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, dp[i + 1], 1, m);
        }
        
        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(dp[i][j] == 0) continue;

                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
