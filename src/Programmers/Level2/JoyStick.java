package Programmers.Level2;

public class JoyStick {
    public static void main(String[] args) {
        JoyStick sol = new JoyStick();
        String name = "JEROEN";

        int answer = sol.solution(name);
        System.out.println(answer);
    }

    public int solution(String name) {
        int answer = 0;
        int[] cal = new int[26];
        for (int i = 0; i < 13; i++) {
            cal[i] = i;
        }
        for (int i = 0; i < 13; i++) {
            cal[25 - i] = i;
        }
        for (int i = 0; i < name.length(); i++) {

        }
        return answer;
    }
}
