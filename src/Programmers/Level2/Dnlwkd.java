package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dnlwkd {
    public static void main(String[] args) {
        Dnlwkd sol = new Dnlwkd();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(sol.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], new ArrayList<>());
            }
            map.get(clothes[i][1]).add(clothes[i][0]);
        }

        for(String key : map.keySet()) {
            answer *= (map.get(key).size() + 1);
        }
        return answer - 1;
    }
}
