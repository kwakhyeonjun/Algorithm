package Programmers.Curriculum;

public class P42842 {
    public static void main(String[] args) {

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i != 0) continue;
            int m = yellow/i;
            if(2 * (i + m + 2) == brown) {
                answer = new int[]{m + 2, i + 2};
                break;
            }
        }
        return answer;
    }
}
