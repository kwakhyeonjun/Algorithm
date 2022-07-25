package Programmers.Curriculum;

public class P72410 {
    public static void main(String[] args) {
        String new_id = "=.=";
        P72410 sol = new P72410();
        System.out.println(sol.solution(new_id));
    }

    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            char cur = new_id.charAt(i);
            if((cur >= 'a' && cur <= 'z') || (cur >= '0' && cur <= '9')
                || cur == '-' || cur == '_' || cur == '.') sb.append(cur);
        }
        new_id = sb.toString();
        while(!new_id.equals(new_id.replace("..", "."))) {
            new_id = new_id.replace("..", ".");
        }
        if(new_id.length() > 0 && new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if(new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);

        if("".equals(new_id)) new_id = "a";

        if(new_id.length() >= 16) new_id = new_id.substring(0, 15);

        if(new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);

        if(new_id.length() <= 2) {
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while(new_idBuilder.length() < 3) {
                new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
            }
            new_id = new_idBuilder.toString();
        }

        return new_id;
    }
}
