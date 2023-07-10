package Programmers.ret;

public class P12951 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean isFirst = true;

        for (char c : s.toLowerCase().toCharArray()) {
            sb.append(isFirst ? (c + "").toUpperCase() : c);
            isFirst = c == ' ';
        }

        return sb.toString();
    }
}
