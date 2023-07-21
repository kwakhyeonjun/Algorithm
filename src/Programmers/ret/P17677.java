package Programmers.ret;

import java.util.HashSet;
import java.util.Set;

public class P17677 {
    public int solution(String str1, String str2) {
       Set<String> set1 = getSet(str1.toLowerCase());
        Set<String> set2 = getSet(str2.toLowerCase());

        double result = jakad(set1, set2);

        return (int)(result * 65536);
    }

    private double jakad(Set<String> set1, Set<String> set2) {
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        // System.out.println(union);

        Set<String> diff = new HashSet<>(set1);
        diff.retainAll(set2);
        // System.out.println(diff);

        if(diff.size() == 0 && union.size() == 0) return 1.0;
        return (double)diff.size() / (double)union.size();
    }

    private Set<String> getSet(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            sb.append(c);
            String cur = sb.toString();
            if(cur.length() <= 1) continue;
            if(isAlphabet(cur)) {
                while(set.contains(cur)) {
                    cur = cur + "1";
                }
                set.add(cur);
            }
            sb.delete(0, 1);
        }
        return set;
    }

    private boolean isAlphabet(String s) {
        for(char c : s.toCharArray()) {
            if(c < 'a' || c > 'z') return false;
        }
        return true;
    }
}
