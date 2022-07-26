package Programmers.Curriculum;

public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] uniform = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            uniform[i] = 1;
        }

        for (int j : lost) {
            uniform[j]--;
        }
        for (int j : reserve) {
            uniform[j]++;
        }

        for(int i = 1; i < n + 1; i++) {
            if(uniform[i] != 0) continue;
            if(i + 1 <= n && uniform[i+1] > 1) {
                uniform[i+1]--;
                uniform[i]++;
            } else if (i - 1 > 0 && uniform[i - 1] > 1) {
                uniform[i-1]--;
                uniform[i]++;
            }
        }
        for(int i = 1; i < n + 1; i++) {
            if(uniform[i] >= 1) answer++;
        }
        return answer;
    }
}
