package Programmers.Level2;

import java.util.PriorityQueue;

//
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
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int s : scoville) {
            pq.add(s);
        }

        while(pq.peek() < K) {
            if(pq.size() == 1) return -1;
            int min1 = pq.poll();
            int min2 = pq.poll();

            int mix = min1 + (2 * min2);
            pq.add(mix);
            answer++;
        }

        return answer;
    }
}
