package Programmers.Curriculum;

import java.util.HashMap;

public class P42578 {
    public static void main(String[] args) {
        P42578 sol = new P42578();
        System.out.println(sol.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }

        for(String key : map.keySet()) answer *= map.get(key);

        return answer - 1;
    }
}
