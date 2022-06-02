package Programmers.Level2;

import java.util.ArrayList;

public class Develop {
    public static void main(String[] args) {
        Develop sol = new Develop();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer = sol.solution(progresses, speeds);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] done = new boolean[progresses.length];
        int doneIndex = 0;

        while(!isDone(done)) {
            for(int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if(progresses[i] >= 100) done[i] = true;
            }
            int doneCount = 0;
            for (int i = doneIndex; i < progresses.length; i++) {
                if(done[doneIndex]) {
                    doneIndex++;
                    doneCount++;
                }
                else break;
            }
            if(doneCount != 0) list.add(doneCount);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private boolean isDone(boolean[] done) {
        for(int i = 0; i < done.length; i++) {
            if(!done[i]) return false;
        }
        return true;
    }
}
