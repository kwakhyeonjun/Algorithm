package Programmers.Level2;

public class Land {
    public static void main(String[] args) {
        Land sol = new Land();

        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(sol.solution(land));
    }

    public int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = 0;
                for (int k = 0; k < land[i].length; k++) {
                    if(j == k) continue;
                    max = Math.max(max, land[i][k]);
                }
                dp[i][j] += dp[i-1][j] + max;
            }
        }

        int answer = 0;

        for (int i = 0; i < dp[0].length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }
}
