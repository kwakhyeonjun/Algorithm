package Programmers.Level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P181188 {
    public static void main(String[] args) {
        P181188 sol = new P181188();
        int answer = sol.solution(new int[][]{{1, 4}, {2, 5}, {4, 7}});
        System.out.println(answer);
    }
    public int solution(int[][] targets) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        pq.addAll(Arrays.asList(targets));

        while(!pq.isEmpty()) {
            int[] prev = pq.poll();
            answer++;
            while(!pq.isEmpty() && pq.peek()[0] < prev[1]) {
                int[] cur = pq.poll();
            }
        }

        return answer;
    }
}
