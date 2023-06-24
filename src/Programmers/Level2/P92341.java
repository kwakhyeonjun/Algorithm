package Programmers.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P92341 {

    public static void main(String[] args) {
        P92341 sol = new P92341();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] solution = sol.solution(fees, records);

        for (int j : solution) {
            System.out.print(j + " ");
        }

    }

    public int[] solution(int[] fees, String[] records) {

        for(String record : records) {
            String[] cur = record.split(" ");
            if("IN".equals(cur[2])) {
                if (!map.containsKey(cur[1])) {
                    map.put(cur[1], new Record());
                }
                map.get(cur[1]).start = getTime(cur[0]);
            } else {
                map.get(cur[1]).setTot(getTime(cur[0]));
            }
        }

        Object[] arr = map.keySet().toArray();
        Arrays.sort(arr);
        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            String key = (String) arr[i];
            Record cur = map.get(key);

            if(cur.start != null) {
                cur.setTot(LAST);
            }

            System.out.print("key = " + key);
            System.out.println(", cur = " + cur);

            if(fees[0] > cur.tot) {
                answer[i] = fees[1];
                continue;
            }
            answer[i] = fees[1] + (int) Math.ceil((double)(cur.tot - fees[0]) / fees[2]) * fees[3];
        }

        return answer;
    }

    final int LAST = getTime("23:59");
    Map<String, Record> map = new HashMap<>();

    private int getTime(String time) {
        String[] cur = time.split(":");
        return 60 * Integer.parseInt(cur[0]) + Integer.parseInt(cur[1]);
    }
    static class Record {
        Integer start;
        int tot;

        public void setTot(int end) {
            this.tot += end - start;
            start = null;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "start=" + start +
                    ", tot=" + tot +
                    '}';
        }
    }
}
