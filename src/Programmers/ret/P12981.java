package Programmers.ret;

import java.util.HashSet;
import java.util.Set;

public class P12981 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();

        String prev = words[0];
        set.add(prev);

        for (int i = 1; i < words.length; i++) {
            if(set.contains(words[i]) || prev.charAt(prev.length() - 1) != words[i].charAt(0)) {
                return new int[]{i%n + 1, i/n + 1};
            }
            set.add(words[i]);
            prev = words[i];
        }
        return new int[]{0, 0};
    }
}
