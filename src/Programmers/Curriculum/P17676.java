package Programmers.Curriculum;

import java.util.ArrayList;
import java.util.List;

public class P17676 {
    public int solution(String[] lines) {
        int answer = 0;

        List<int[]> list = new ArrayList<>();

        for (String line : lines) {
            String[] log = line.split(" ");
            String[] responseTime = log[1].split(":");
            int processingTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);

            int endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
            endTime += (int) (Double.parseDouble(responseTime[2]) * 1000);
            int startTime = endTime - processingTime + 1;

            list.add(new int[]{startTime, endTime});
        }

        for(int i = 0 ; i < lines.length ; ++i) {
            int cnt = 0;
            int start = list.get(i)[0];
            int end = start + 1000;

            for(int j = 0 ; j < lines.length ; ++j) {
                int nextStart = list.get(j)[0];
                int nextEnd = list.get(j)[1];
                if(nextStart >= start && nextStart < end) {
                    cnt++;
                } else if(end >= start && nextEnd < end) {
                    cnt++;
                } else if(nextStart <= start && nextEnd >= end) {
                    cnt++;
                }
            }

            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
