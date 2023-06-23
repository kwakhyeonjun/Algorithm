package Programmers.Level1;

public class P132267 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a) {
            int cur = n - n % a;
            int get = cur / a * b;
            answer += get;
            n = get + n % a;
        }

        return answer;
    }
}
