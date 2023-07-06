package Programmers.ret;

public class P12939 {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String cur : s.split(" ")) {
            int n = Integer.parseInt(cur);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return min + " " + max;
    }
}
