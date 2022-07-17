package Programmers.Curriculum;

import java.util.HashMap;

public class P42576 {

    public static void main(String[] args) {
        P42576 sol = new P42576();
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completion) {
            if(map.get(c) == 1) map.remove(c);
            else map.put(c, map.get(c) - 1);
        }

        for(String a : map.keySet()) {
            answer = a;
        }

        return answer;
    }
}
