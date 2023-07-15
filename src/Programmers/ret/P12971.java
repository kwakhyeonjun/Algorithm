package Programmers.ret;

public class P12971 {
    public static void main(String[] args) {
        P12971 sol = new P12971();
        int answer = sol.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10});
        System.out.println(answer);
    }
    public int solution(int[] sticker) {
        int n = sticker.length;

        if(n == 1) return sticker[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
