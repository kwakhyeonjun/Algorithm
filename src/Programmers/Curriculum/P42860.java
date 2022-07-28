package Programmers.Curriculum;

public class P42860 {
    public static void main(String[] args) {

    }

    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 지금 글자의 위, 아래

            index = i + 1; // 바로 다음 글자

            while(index < name.length() && name.charAt(index) == 'A') { // 다음 글자가 'A' 라면 다음글자로
                index++;
            }

            move = Math.min(move, i * 2 + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        return answer + move;
    }
}
