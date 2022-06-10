package Programmers.Level2;

public class Match {
    public static void main(String[] args) {
        Match sol = new Match();
        int n = 8;
        int a = 4;
        int b = 7;
        int answer = sol.solution(n, a, b);
        System.out.println(answer);
    }

    public int solution(int n, int a, int b) {
        int answer = 0;
        while(a != b) {
            answer++;
            a = (a+1)/2;
            b = (b+1)/2;
        }
        return answer;
    }
}
