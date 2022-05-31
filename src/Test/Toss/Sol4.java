package Test.Toss;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Sol4 {
    public static void main(String[] args) throws ParseException {
        String s = "2021:04:12:16:08:35";
        String[] times = {"00:01:30:00", "00:01:12:00"};
        int[] sol = solution(s, times);
        System.out.println(sol[0] + " " + sol[1]);
    }

    public static int[] solution(String s, String[] times) throws ParseException {
        int[] answer = new int[2];
        // default = 성공
        answer[0] = 1;
        
        // 당일 포함
        answer[1] = 1;

        // s를 파싱
        Date lateDate = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").parse(s);
        Calendar curCal = Calendar.getInstance();
        curCal.setTime(lateDate);
        for(String time : times) {
            StringTokenizer st = new StringTokenizer(time, ":");
            int day = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            // 시간 더함
            curCal.add(Calendar.DATE, day);
            curCal.add(Calendar.HOUR, hour);
            curCal.add(Calendar.MINUTE, min);
            curCal.add(Calendar.SECOND, sec);
            Date curDate = new Date(curCal.getTimeInMillis());
            Calendar lateCal = Calendar.getInstance();
            lateCal.setTime(lateDate);
            // 이전 저축과 이번 저축의 날짜 차이
            int diff = curCal.get(Calendar.DATE) - lateCal.get(Calendar.DATE);
            // 이번 저축을 이전 저축으로
            lateDate = curDate;
            // 1일 1저축 실패
            if(diff > 1) {
                answer[0] = 0;
            }
            answer[1] += diff;
        }
        return answer;
    }
}
