package Programmers.Level2;

public class P12939 {
    public String solution(String s) {
        String answer = "";

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] arr = s.split(" ");

        for(String cur : arr) {
            int num = Integer.parseInt(cur);

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return min + " " + max;
    }
}
