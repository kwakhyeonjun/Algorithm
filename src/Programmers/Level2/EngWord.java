package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class EngWord {
    public static void main(String[] args) {
        EngWord sol = new EngWord();
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] answer = sol.solution(n, words);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        String prev = words[0];
        set.add(prev);

        for (int i = 1; i < words.length; i++) {
            if(set.contains(words[i]) || prev.charAt(prev.length() - 1) != words[i].charAt(0)) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }
            set.add(words[i]);
            prev = words[i];
        }

        return answer;
    }
}
