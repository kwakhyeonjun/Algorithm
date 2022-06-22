package Programmers.Level2;

import java.util.ArrayList;

public class PrevMusic {
    public static void main(String[] args) {
        PrevMusic sol = new PrevMusic();
        String m = "CCB";
        String[] musicinfos = {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"};
        System.out.println(sol.solution(m, musicinfos));
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "None";
        int max = 0;
        for(String musicinfo : musicinfos) {
            String[] curInfo = musicinfo.split(",");

            String[] start = curInfo[0].split(":");
            String[] end = curInfo[1].split(":");

            int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
            int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            min += hour * 60;

            ArrayList<String> list = new ArrayList<>();

            String notes = "CDEFGAB";

            StringBuilder sb = new StringBuilder();
            for (char c : curInfo[3].toCharArray()) {
                if(notes.contains(c + "")) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append(c);
            }
            list.add(sb.toString());
            list.remove(0);

            int idx = 0;
            int count = 0;
            sb = new StringBuilder();
            while(count++ < min) {
                if(idx == list.size()) idx = 0;
                sb.append(list.get(idx++));
            }

            if(sb.toString().contains(m) && max < min) {
                StringBuilder temp = new StringBuilder(m);
                temp.append("#");
                if(sb.toString().contains(temp)) continue;
                answer = curInfo[2];
                max = min;
            }
        }
        return answer;
    }
}
