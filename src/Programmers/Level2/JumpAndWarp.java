package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class JumpAndWarp {
    public static void main(String[] args) {
        JumpAndWarp sol = new JumpAndWarp();
        System.out.println(sol.solution(1000000000));
    }

    public int solution1(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            // case 2
            if(cur[0] * 2 == n) return cur[1];
            queue.add(new int[]{cur[0] * 2, cur[1]});

            // case 1
            if(cur[0] + 1 == n) return cur[1] + 1;
            queue.add(new int[]{cur[0] + 1, cur[1] + 1});
        }
        return -1;
    }
    public int solution3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            if(i%2 != 0) {
                dp[i] = dp[i - 1] + 1;
                continue;
            }
            dp[i] = Math.min(dp[i/2], dp[i - 1] + 1);
        }
        return dp[n];
    }

    public int solution(int n) {
        int answer = 1;
        while(n != 1) {
            if(n%2 == 0) n /= 2;
            else {
                answer++;
                n -= 1;
            }
        }
        return answer;
    }
}
