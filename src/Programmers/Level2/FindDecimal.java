package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class FindDecimal {
    public static void main(String[] args) {
        FindDecimal sol = new FindDecimal();
        String numbers = "121";
        int answer = sol.solution(numbers);
        System.out.println(answer);
    }

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        picked = new char[numbers.length()];
        set = new HashSet<>();
        comb(numbers, 0);
        for(int n : set) {
            if(isDecimal(n)) answer++;
        }
        return answer;
    }

    private boolean[] visited;
    private char[] picked;
    private Set<Integer> set;

    private void comb(String numbers, int count) {
        if(count > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(picked[i]);
            }
            int cur = Integer.parseInt(sb.toString());
            set.add(cur);
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            picked[count] = numbers.charAt(i);
            comb(numbers, count + 1);
            visited[i] = false;
        }
    }

    private boolean isDecimal(int num) {
        if(num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}
