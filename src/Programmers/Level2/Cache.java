package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public static void main(String[] args) {
        Cache sol = new Cache();
        int cacheSize = 5;
        String[] cities = {"SEOUL", "SEOUL", "SEOUL"};
        System.out.println(sol.solution(cacheSize, cities));
    }

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5 * cities.length;
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for(String city : cities) {
            city = city.toLowerCase();
            if(queue.remove(city)) {
                queue.add(city);
                answer++;
                continue;
            }
            if(cacheSize == queue.size()) queue.poll();
            queue.add(city);
            answer += 5;
        }

        return answer;
    }
}
