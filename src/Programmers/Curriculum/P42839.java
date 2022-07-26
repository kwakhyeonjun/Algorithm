package Programmers.Curriculum;

import java.util.HashSet;
import java.util.Set;

public class P42839 {
    public static void main(String[] args) {
        String numbers = "17";
        P42839 sol = new P42839();

        System.out.println(sol.solution(numbers));
    }

    public int solution(String numbers) {
        picked = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        comb(numbers, 0);
        return set.size();
    }

    char[] picked;
    boolean[] visited;
    Set<Integer> set;

    private void comb(String numbers, int count) {
        if(count > 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < count; i++){
                sb.append(picked[i]);
            }
            int cur = Integer.parseInt(sb.toString());
            System.out.println(cur);
            if(isPrime(cur)) {
                set.add(cur);
            }
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            picked[count] = numbers.charAt(i);
            visited[i] = true;
            comb(numbers, count + 1);
            visited[i] = false;
        }
    }

    private boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number%i == 0) return false;
        }
        return true;
    }
}
