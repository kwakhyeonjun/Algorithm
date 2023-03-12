package Programmers.Curriculum;

import java.util.Stack;

public class P60058 {
    public static void main(String[] args) {

    }

    // TODO
//    public String solution(String p) {
//
//    }

    private boolean isNull(String p){
        if("".equals(p)) return true;
        return false;
    }

    private String splitUV(String p) {
        if(isNull(p)) return "";
        int count = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') count++;
            else count--;
            if(count == 0) return splitUV(p.substring(0, i));
        }
        return null;
    }
}
