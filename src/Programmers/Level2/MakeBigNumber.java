package Programmers.Level2;

public class MakeBigNumber {
    public static void main(String[] args) {
        MakeBigNumber sol = new MakeBigNumber();
        String number = "1231234";
        int k = 3;
        System.out.println(sol.solution(number, k));
    }

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = index; j <= k + i; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
