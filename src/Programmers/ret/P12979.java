package Programmers.ret;

public class P12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cur = 1;
        int idx = 0;

        while(cur <= n) {
            if(idx < stations.length && stations[idx] - w <= cur) {
                cur = stations[idx] + w + 1;
                idx++;
            } else {
                answer++;
                cur += 2 * w + 1;
            }
        }
        return answer;
    }
}
