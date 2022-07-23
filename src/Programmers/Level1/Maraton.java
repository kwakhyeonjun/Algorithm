package Programmers.Level1;

import java.util.HashMap;

public class Maraton {
    public static void main(String[] args) {
        Maraton sol = new Maraton();
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        System.out.println(sol.solution(part, comp));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = null;
        HashMap<String, Integer> map = new HashMap<>();
        for(String part : participant) {
            if(!map.containsKey(part)) {
                map.put(part, 1);
            } else {
                map.put(part, map.get(part) + 1);
            }
        }

        for(String comp : completion) {
            if(map.get(comp) == 1) map.remove(comp);
            else {
                map.put(comp, map.get(comp) - 1);
            }
        }

        for(String temp : map.keySet()) answer = temp;

        return answer;
    }
}
