package Programmers.Level2;

import java.util.PriorityQueue;

public class P178870 {

    public static void main(String[] args) {
        P178870 sol = new P178870();
        int[] answer = sol.solution(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println(answer[0] + ", " + answer[1]);
    }


    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;

        int start = 0;
        int end = 0;
        int sum = sequence[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int o1Len = o1[1] - o1[0];
            int o2Len = o2[1] - o2[0];

            if(o1Len == o2Len) return o1[0] - o2[0];
            return o1Len - o2Len;
        });

        while(true) {
            if(start == n && end == n - 1) break;
            if(sum == k) pq.offer(new int[]{start, end});

            if(sum <= k && end < n - 1) sum += sequence[++end];
            else sum -= sequence[start++];
        }

        return pq.poll();
    }
}
