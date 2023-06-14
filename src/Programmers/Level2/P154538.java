package Programmers.Level2;

public class P154538 {
    public static void main(String[] args) {
        P154538 sol = new P154538();
        int solution = sol.solution(2, 5, 4);
        System.out.println(solution);
    }
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        for(int i = x + 1; i <= y; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = x + 1; i <= y; i++) {
            if(i/3 >= x && dp[i/3] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if(i/2 >= x && dp[i/2] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i - n >= x && dp[i - n] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - n] + 1);
        }

        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}
