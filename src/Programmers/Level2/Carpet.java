package Programmers.Level2;

public class Carpet {
    public static void main(String[] args) {
        Carpet sol = new Carpet();
        int brown = 10;
        int yellow = 2;
        int[] answer = sol.solution(brown, yellow);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i != 0) continue;
            int n = i;
            int m = yellow/i;
            if(2 * (n + m + 2) == brown) {
                answer = new int[]{m + 2, n + 2};
                break;
            }
        }

        return answer;
    }
}
