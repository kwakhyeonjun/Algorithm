package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;

public class MoreHot {
    public static void main(String[] args) {
        MoreHot sol = new MoreHot();
        int[] scobille = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = sol.solution(scobille, K);
        System.out.println(answer);
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        ArrayList<Integer> scoList = new ArrayList<>();
        for (int i = 0; i < scoville.length; i++) {
            scoList.add(scoville[i]);
        }
        Arrays.sort(scoville);
        while(scoList.get(0) < K){
            answer++;
            int sum = scoList.get(0) + (2 * scoList.get(1));
            scoList.remove(0);
            scoList.remove(1);
            scoList.add(sum);
            Arrays.sort(scoville);
        }
        return answer;
    }
}
