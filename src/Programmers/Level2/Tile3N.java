package Programmers.Level2;

public class Tile3N {
    public static void main(String[] args) {
        Tile3N sol = new Tile3N();
        System.out.println(sol.solution(4));
    }
    public int solution(int n) {
        if(n%2 != 0) return 0;

        long[] dp = new long[n + 1];
        int mod = 1000000007;
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i < n + 1; i += 2) {
            dp[i] += dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] = dp[i] % mod;
        }
        return (int)dp[n];
    }
}
