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
        int index; // 다음 값들을 확인할 때 사용
        int move = name.length() - 1; // 좌우 움직임 수를 체크
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i+ 1;
            // 연속하는 A 개수 확인
            while(index < name.length() && name.charAt(index) =='A') {
                index++;
            }

            move = Math.min(move, i * 2 + name.length() - index);

            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        return answer + move;
    }
}
