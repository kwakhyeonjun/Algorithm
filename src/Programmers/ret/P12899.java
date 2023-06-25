package Programmers.ret;

public class P12899 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String num = "412";

        while(n > 0) {
            sb.append(num.charAt(n % 3));
            n = (n - 1) / 3;
        }

        return sb.reverse().toString();
    }
}
