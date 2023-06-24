package Programmers.Level2;

public class P12951 {

    public static void main(String[] args) {
        P12951 sol = new P12951();
        System.out.println(sol.solution("3people unFollowed me"));
    }

    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        Character cur = null, prev = null;

        for(char c : s.toCharArray()) {
            cur = c;
            if(prev == null) sb.append(cur);
            if(prev == ' ') {
                if(cur >= '0' && cur <= '9') sb.append(cur);
                else sb.append((char)(cur - 'a' + 'A'));
            } else {
                if(cur >= 'A' && cur <= 'Z') sb.append((char)(cur - 'A' + 'a'));
                else sb.append(cur);
            }

            prev = cur;
        }

        return sb.toString();
    }
}
