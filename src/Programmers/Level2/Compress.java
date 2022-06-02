package Programmers.Level2;

public class Compress {
    public static void main(String[] args) {
        Compress sol = new Compress();
        String s = "a";
        int answer = sol.solution(s);
        System.out.println(answer);
    }
    public int solution(String s) {
        String min = null;
        if(s.length() == 1) return 1;
        for (int i = 1; i <= s.length()/2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;
            String sub = null;
            for (int j = i; j < s.length(); j+=i) {
                if(j + i > s.length()) sub = s.substring(j, s.length());
                else sub = s.substring(j, j + i);
                if(sub.equals(prev)) {
                    count++;
                } else {
                    if(count == 1) sb.append(prev);
                    else sb.append(count).append(prev);
                    prev = sub;
                    count = 1;
                }
            }
            if(count == 1) sb.append(sub);
            else {
                if(sub.equals(prev)) sb.append(count).append(sub);
                else sb.append(sub);
            }
            if(min == null) min = sb.toString();
            if(sb.length() < min.length()) min = sb.toString();
        }
        return min.length();
    }
}
