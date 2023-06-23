package Programmers.ret;

import java.util.*;

public class P43163 {
    public static void main(String[] args) {
        P43163 sol = new P43163();

        int solution = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(solution);
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();

        StringBuilder sb;

        boolean flag = false;

        for(String word : words) {
            if(target.equals(word)) flag = true;
            visited.put(word, false);
            for(int i = 0; i < word.length(); i++) {
                sb = new StringBuilder();
                for(int j = 0; j < word.length(); j++) {
                    if(j == i) {
                        sb.append("*");
                        continue;
                    }
                    sb.append(word.charAt(j));
                }
                if(!map.containsKey(sb.toString())) map.put(sb.toString(), new ArrayList<>());
                map.get(sb.toString()).add(word);
            }
        }

        if(!flag) return 0;

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(begin, 0));
        visited.put(begin, true);

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for(int i = 0; i < cur.word.length(); i++) {
                sb = new StringBuilder();
                for(int j = 0; j < cur.word.length(); j++) {
                    if(i == j) {
                        sb.append("*");
                        continue;
                    }
                    sb.append(cur.word.charAt(j));
                }

                if(map.containsKey(sb.toString())) {
                    for(String val : map.get(sb.toString())) {
                        if(val.equals(target)) return cur.count + 1;
                        if(visited.get(val)) continue;
                        queue.add(new Pos(val, cur.count + 1));
                        visited.put(val, true);
                    }
                }
            }
        }

        return answer;
    }

    static class Pos {
        String word;
        int count;

        public Pos(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
