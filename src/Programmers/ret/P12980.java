package Programmers.ret;

public class P12980 {
    public int solution(int n) {
        int answer = 1;

        while(n != 1) {
            if(n % 2 == 0) n /= 2;
            else {
                n--;
                answer++;
            }
        }
        return answer;
    }
}
