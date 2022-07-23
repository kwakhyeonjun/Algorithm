package Programmers.Curriculum;

import java.util.Arrays;

public class P42748 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        P42748 sol = new P42748();
        int[] answer = sol.solution(array, commands);
        for(int i : answer) System.out.print(i + " ");
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for(int[] command : commands) {
            int[] split = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(split);
            answer[idx++] = split[command[2] - 1];
        }

        return answer;
    }
}
