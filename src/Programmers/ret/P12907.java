package Programmers.ret;

public class P12907 {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int m : money) {
            for (int j = m; j <= n; j++) {
                dp[j] += dp[j - m];
            }
        }

        return dp[n];
    }
}
