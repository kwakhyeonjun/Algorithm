package Programmers.Curriculum;

import java.util.ArrayList;
import java.util.List;

public class P42840 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] index = new int[3];
        int[] point = new int[3];

        for(int answer : answers) {
            if(index[0] == one.length) index[0] = 0;
            if(index[1] == two.length) index[1] = 0;
            if(index[2] >= three.length) index[2] = 0;

            if(one[index[0]++] == answer) point[0]++;
            if(two[index[1]++] == answer) point[1]++;
            if(three[index[2]++] == answer) point[2]++;
        }

        List<Integer> answerList = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for(int p : point) {
            max = Math.max(max, p);
        }

        for(int i = 0; i < 3; i++) {
            if(max == point[i]) answerList.add(i + 1);
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
