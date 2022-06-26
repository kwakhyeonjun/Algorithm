package Programmers.SkillCheck;

public class SkillCheck2_1_1 {
    public static void main(String[] args) {
        SkillCheck2_1_1 sol = new SkillCheck2_1_1();
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;
        System.out.println(sol.solution(n, t, m, p));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder call = new StringBuilder();
        int cur = 0;
        while(call.length() <= t * m + p) {
            call.append(getDigit(n, cur++));
        }

        for (int i = p - 1; i < t * m; i += m) {
            answer.append(call.charAt(i));
        }

        return answer.toString();
    }

    private String getDigit(int n, int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
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
                    sb.append(num%n);
            }
            num /= n;
        }
        if(sb.toString().equals("")) return "0";
        return sb.reverse().toString();
    }
}
