package Programmers.Level2;

public class ChangeBinary {
    public static void main(String[] args) {
        ChangeBinary sol = new ChangeBinary();
        int[] answer = sol.solution("110010101001");
        for(int i : answer) System.out.print(i + " ");
    }

    public int[] solution(String s) {
        int zero = 0, times = 0;
        while(!s.equals("1")) {
            times++;
            int one = 0;
            for(char c : s.toCharArray()) {
                if(c == '1') one++;
                else zero++;
            }
            s = Integer.toBinaryString(one);
        }
        return new int[]{times, zero};
    }
}
