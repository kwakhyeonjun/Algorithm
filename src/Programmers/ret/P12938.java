package Programmers.ret;

public class P12938 {
    public static void main(String[] args) {
        P12938 sol = new P12938();
        int[] answer = sol.solution(2, 9);
        for (int i : answer) {
            System.out.println(i);
        }

    }
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int div = s / n;

        if(div == 0) return new int[]{-1};

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += div;
            answer[i] = div;
        }

        for(int i = n - 1; i >= n - s + sum; i--) {
            answer[i]++;
        }

        return answer;
    }
}
