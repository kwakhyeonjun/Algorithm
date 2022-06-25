package Programmers.Level2;

public class Bracket {
    public static void main(String[] args) {
        Bracket sol = new Bracket();
        String s = "";
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') count++;
            else {
                if(count == 0) return false;
                count--;
            }
        }
        if(count > 0) return false;
        return true;
    }
}
