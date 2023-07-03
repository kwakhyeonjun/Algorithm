package Programmers.ret;

import java.util.Collections;
import java.util.PriorityQueue;

public class P12927 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        for (int i = 0; i < n; i++) {
            if(pq.isEmpty()) break;
            int cur = pq.poll();
            if(cur <= 0) break;
            pq.offer(cur - 1);
        }

        long answer = 0;

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            answer += (long) cur * cur;
        }

        return answer;
    }
}
