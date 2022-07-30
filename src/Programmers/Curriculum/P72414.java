package Programmers.Curriculum;

import java.util.*;

public class P72414 {
    public static void main(String[] args) {
        P72414 sol = new P72414();
        String play_time = "99:59:59"	;
        String adv_time = "25:00:00"	;
        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        System.out.println(sol.solution(play_time, adv_time, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {

        int play = getSec(play_time);
        int adv = getSec(adv_time);

        int[] count = new int[play+1];

        for(String log : logs) {
            String[] cur = log.split("-");
            for(int j = getSec(cur[0]); j < getSec(cur[1]); j++) {
                count[j]++;
            }
        }

        int answer = 0;

        long MAX = 0;
        for(int i = 0; i <= adv; i++) {
            MAX += count[i];
        }

        long cur = MAX;
        for(int i = 0; i <= play - adv; i++){
            cur = cur - count[i] + count[i + adv];
            if(cur > MAX) {
                MAX = cur;
                answer = i + 1;
            }
        }

        return getTime(answer);
    }

    private int getSec(String time) {
        int h, m, s;
        String[] split = time.split(":");
        h = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        s = Integer.parseInt(split[2]);
        return s + m * 60 + h * 60 * 60;
    }

    private String getTime(int sec) {
        int h, m;
        String hh, mm, ss;
        h = sec/(60 * 60);
        hh = (h < 10)?"0" + h:String.valueOf(h);
        sec -= h * 60 * 60;
        m = sec/60;
        mm = (m < 10)?"0" + m:String.valueOf(m);
        sec -= m * 60;
        ss = (sec < 10)?"0" + sec:String.valueOf(sec);
        return hh + ":" + mm + ":" + ss;
    }
}
