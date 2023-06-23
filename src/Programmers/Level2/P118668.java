package Programmers.Level2;

public class P118668 {

    public static void main(String[] args) {
        P118668 sol = new P118668();
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};
        int solution = sol.solution(alp, cop, problems);
        System.out.println(solution);
    }

    public int solution(int alp, int cop, int[][] problems) {
        int MAX_ALP = 0;
        int MAX_COP = 0;
        for(int[] problem : problems) {
            MAX_ALP = Math.max(MAX_ALP, problem[0]);
            MAX_COP = Math.max(MAX_COP, problem[1]);
        }

        if (alp >= MAX_ALP && cop >= MAX_COP) return 0;

        int[][] dp = new int[MAX_ALP + 1][MAX_COP + 1];

        for (int i = 0; i <= MAX_ALP; i++) {
            for (int j = 0; j <= MAX_COP; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        if(alp > MAX_ALP) alp = MAX_ALP;
        if(cop > MAX_COP) cop = MAX_COP;

        dp[alp][cop] = 0;

        for (int i = alp; i <= MAX_ALP; i++) {
            for (int j = cop; j <= MAX_COP; j++) {
                // case 1: alp++;
                if(i + 1 <= MAX_ALP)
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);

                // case 2: cop++;
                if(j + 1 <= MAX_COP)
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                // case 3: problems
                for(int[] problem : problems) {
                    // 요구 조건을 충족하지 못하는 경우
                    if(problem[0] > i || problem[1] > j) continue;

                    int newAlp = i + problem[2];
                    int newCop = j + problem[3];

                    if(newAlp > MAX_ALP) newAlp = MAX_ALP;
                    if(newCop > MAX_COP) newCop = MAX_COP;

                    dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + problem[4]);
                }
            }
        }

        return dp[MAX_ALP][MAX_COP];
    }
}
