package Programmers.Level2;

public class NBitGame {
    public static void main(String[] args) {
        NBitGame sol = new NBitGame();
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;

        System.out.println(sol.solution(n, t, m, p));
    }

    public String solution(int n, int t, int m, int p) {

        StringBuilder answer = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        int cur = 0;

        while(numbers.length() <= t * m + p) {
            numbers.append(getBinary(n, cur++));
        }

        for(int i = p - 1; i < t * m + p - 1; i += m) {
            answer.append(numbers.charAt(i));
        }
        return answer.toString();
    }

    private String getBinary(int n, int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            switch (num % n) {
                case 10:
                    sb.append("A");
                    break;
                case 11:
                    sb.append("B");
                    break;
                case 12:
                    sb.append("C");
                    break;
                case 13:
                    sb.append("D");
                    break;
                case 14:
                    sb.append("E");
                    break;
                case 15:
                    sb.append("F");
                    break;
                default:
                    sb.append(num % n);
                    break;
            }
            num /= n;
        }

        return sb.reverse().toString();
    }
}
