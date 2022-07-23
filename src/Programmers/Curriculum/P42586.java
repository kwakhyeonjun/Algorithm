package Programmers.Curriculum;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P42586 {
    public static void main(String[] args) {
        P42586 sol = new P42586();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = sol.solution(progresses, speeds);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
