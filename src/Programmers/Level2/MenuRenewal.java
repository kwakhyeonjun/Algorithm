package Programmers.Level2;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        MenuRenewal sol = new MenuRenewal();
        String[] answers = sol.solution(orders, course);
        for (String answer : answers) {
            System.out.print(answer + " ");
        }
    }

    // 각 주문의 원소가 course 개수인 주문을 저장해야함.
    public String[] solution(String[] orders, int[] course) {

        Set<String> set = new HashSet<>();
        for(int courseCount : course) {
            map = new HashMap<>();
            for(String order : orders) {
                char[] orderList = order.toCharArray();
                Arrays.sort(orderList);
                String cur = new String(orderList);
                picked = new char[courseCount];
                visited = new boolean[order.length()];
                setMenu(cur, courseCount, 0, 0);
            }
            int max = Integer.MIN_VALUE;
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            if(max < 2) continue;
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() == max) {
                    set.add(entry.getKey());
                }
            }
        }
        String[] answer = new String[set.size()];
        int index = 0;
        for (String s : set) {
            answer[index++] = s;
        }
        Arrays.sort(answer);
        return answer;
    }

    private HashMap<String, Integer> map;
    private char[] picked;
    private boolean[] visited;

    private void setMenu(String order, int courseCount, int start, int count) {
        if(courseCount == count) {
            String menu = new String(picked);
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }
        for(int i = start; i < order.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            picked[count] = order.charAt(i);
            setMenu(order, courseCount, i + 1, count + 1);
            visited[i] = false;
        }
    }
}
