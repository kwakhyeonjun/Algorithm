package Programmers.Level2;

public class number124 {
    public static void main(String[] args) {
        number124 sol = new number124();
        int n = 3;
        for (int i = 1; i <= 10; i++) {
            String answer = sol.solution(i);
            System.out.println(answer);
        }

    }

    /**
     * 3진법
     */
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int rest = n%3;
            n = (n-1)/3;
            switch (rest) {
                case 0:
                    sb.append("4");
                    break;
                case 1:
                    sb.append("1");
                    break;
                case 2:
                    sb.append("2");
                    break;
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
