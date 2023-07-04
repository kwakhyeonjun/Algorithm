package Programmers.ret;

import java.util.ArrayList;
import java.util.List;

public class P12936 {
    public int[] solution(int n, long k) {
        int size = n;
        List<Integer> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        k--;

        long t = 1;
        for(int i = 1; i <= n; i++) {
            t *= i;
            list.add(i);
        }

        while(n > 0) {
            t /= n;
            int q = (int)(k / t);
            long r = k % t;
            if(q >= list.size()) {
                return null;
            }
            answerList.add(list.remove(q));
            n--;
            k = r;
        }
        int[] answer = new int[size];
        for(int i = 0; i < size; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
