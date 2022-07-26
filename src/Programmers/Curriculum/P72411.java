package Programmers.Curriculum;

import java.util.*;

public class P72411 {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 5};
        P72411 sol = new P72411();
        String[] answer = sol.solution(orders, course);
        for(String a : answer)
            System.out.println(a);
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for(int i = 0; i < orders.length; i++) {
            char[] cur = orders[i].toCharArray();
            Arrays.sort(cur);
            orders[i] = String.valueOf(cur);
        }

        picked = new char[27];


        for(int i : course) {
            map = new HashMap<>();
            for(String order : orders) {
                comb(order, 0, 0, i);
            }
            int max = 0;
            List<String> keys = new ArrayList<>();
            for(String key : map.keySet()) {
                if(map.get(key) == 1) continue;
                if(max < map.get(key)) {
                    max = map.get(key);
                    keys = new ArrayList<>();
                    keys.add(key);
                } else if(max == map.get(key)) {
                    keys.add(key);
                }
            }
            answerList.addAll(keys);
        }

        String[] answer = new String[answerList.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = answerList.get(i);
        Arrays.sort(answer);
        return answer;
    }

    private char[] picked;
    private HashMap<String, Integer> map;

    private void comb(String str, int start, int count, int pick) {
        if(count == pick) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < pick; i++) {
                sb.append(picked[i]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for(int i = start; i < str.length(); i++) {
            picked[count] = str.charAt(i);
            comb(str, i + 1, count + 1, pick);
        }
    }
}
