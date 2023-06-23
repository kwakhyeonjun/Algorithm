package Test.Intern11;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(101,100));
    }

    public int solution(int N, int K) {
        int answer = 0;
        if(K < N) return 1;
        for(int i = N; i > 0; i--) {
            if(K >= i) {
                K -= i;
                answer++;
                i = Math.min(K + 1, i);
            }
            if(K == 0) return answer;
        }
        return -1;
    }

    private int answer;

    private void dfs(int n, int k, int cur, int count) {
        if(cur == k) {
            answer = Math.min(answer, count);
            return;
        }
        for(int i = n; i > 0; i--) {
            if(cur + i > k) continue;
            dfs(k - cur - i, k, cur + i, count + 1);
        }
    }

}
