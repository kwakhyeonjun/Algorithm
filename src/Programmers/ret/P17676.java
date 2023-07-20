package Programmers.ret;

import java.util.ArrayList;
import java.util.List;

public class P17676 {
    public static void main(String[] args) {
        P17676 sol = new P17676();
        int answer = sol.solution(new String[]{
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        });
        System.out.println("answer = " + answer);
    }
    public int solution(String[] lines) {
        int answer = 0;

        List<Log> list = new ArrayList<>();

        for (String line : lines) {
            String[] split = line.split(" ");

            String[] timeSplit = split[1].split(":");
            String[] minSecSplit = timeSplit[2].split("\\.");

            int end = Integer.parseInt(timeSplit[0]) * 60 * 60 * 1000
                    + Integer.parseInt(timeSplit[1]) * 60 * 1000
                    + Integer.parseInt(minSecSplit[0]) * 1000
                    + Integer.parseInt(minSecSplit[1]);

            int respTime = (int) Double.parseDouble(split[2].substring(0, split[2].length() - 1)) * 1000;

            list.add(new Log(end, respTime));
        }

        for (int i = 0; i < list.size(); i++) {
            Log log = list.get(i);
//            System.out.println("log.start = " + log.start);
//            System.out.println("log.end = " + log.end);

            // case1. 시작점 기준
            int count = 0;
            for (Log cur : list) {
                if ((cur.start >= log.start && cur.start < log.start + 1000)
                || (cur.end >= log.start && cur.end < log.start + 1000)
                || (cur.start <= log.start && cur.end >= log.start + 1000)) {
                    count++;
                    System.out.println(cur.end);
                }
            }
            answer = Math.max(count, answer);
//            System.out.println("count = " + count);

            // case2. 끝나는 지점 기준
            count = 0;
            for (Log cur : list) {
                if ((cur.start >= log.end && cur.start < log.end + 1000)
                || (cur.end >= log.end && cur.end < log.end + 1000)
                || (cur.start <= log.end && cur.end >= log.end + 1000)) {
                    count++;
                    System.out.println(cur.end);
                }
            }
            answer = Math.max(count, answer);
//            System.out.println("count = " + count);
        }

        return answer;
    }

    static class Log {
        int start;
        int respTime;
        int end;

        public Log(int end, int respTime) {
            this.end = end;
            this.respTime = respTime;
            this.start = end - respTime + 1;
        }
    }
}
