package Programmers.ret;

public class P12924 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = i; j <= n; j++) {
                count += j;
                if(count > n) break;
                if(count == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
