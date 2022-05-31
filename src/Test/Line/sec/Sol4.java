package Test.Line.sec;

import java.util.Arrays;
import java.util.Collections;

public class Sol4 {

    public static void main(String[] args) {
        int[] t = {2, 8, 3, 6, 1, 9, 1, 9};
        int k = 2;
        System.out.println(solution(t, k));
    }

    public static long solution(int[] abilities, int k) {
        long answer = 0;
        Integer[] a = new Integer[abilities.length];
        for(int i = 0; i < abilities.length; i++) a[i] = abilities[i];
        Arrays.sort(a, Collections.reverseOrder());
        for(int i = 0; i < abilities.length; i += 2) {
            if(abilities.length%2 == 1 && i == abilities.length - 1) {
                if(k > 0){
                    answer += abilities[i];
                }
                continue;
            }
            if(i < abilities.length - 2 && abilities[i] == abilities[i+1]) answer += abilities[i];
            else {
                if(k > 0) {
                    answer += abilities[i];
                    k--;
                }else{
                    answer += abilities[i + 1];
                }
            }
        }
        return answer;
    }
}
