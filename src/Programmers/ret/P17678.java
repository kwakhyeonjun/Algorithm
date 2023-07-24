package Programmers.ret;

import java.util.PriorityQueue;

public class P17678 {
    public String solution(int n, int t, int m, String[] timetable) {
        int start = getTime("09:00");
        int last = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String time : timetable) {
            pq.add(getTime(time));
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            count = 0;
            while(!pq.isEmpty()) {
                int cur = pq.peek();
                if(cur <= start && count < m) {
                    pq.poll();
                    count++;
                } else break;
                last = cur - 1;
            }
            start += t;
        }

        if(count < m) last = start - t;

        return setTime(last);
    }

    private int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String setTime(int time) {
        int hour = time / 60;
        int min = time % 60;
        return String.format("%02d", hour) + ":" + String.format("%02d", min);
    }
}
