package Programmers.Level2;

import java.util.ArrayList;
import java.util.Collections;

// 18:45 ~ 17:10
public class Tuple {
    public static void main(String[] args) {
        Tuple sol = new Tuple();
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] answer = sol.solution(s);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        ArrayList<int[]> tuple = new ArrayList<>();
        ArrayList<Integer> sub = new ArrayList<>();
        for (int i = 1; i < s.length() - 1; i++) {
            char cur = s.charAt(i);
            if(cur == '{') {
                sb = new StringBuilder();
                sub = new ArrayList<>();
            }
            else if(cur >= '0' && cur <= '9') {
                sb.append(cur);
            }
            else if(cur == ',') {
                sub.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            }
            else if(cur == '}') {
                sub.add(Integer.parseInt(sb.toString()));
                int[] subArr = new int[sub.size()];
                for (int j = 0; j < sub.size(); j++) {
                    subArr[j] = sub.get(j);
                }
                tuple.add(subArr);
                i++;
            }
        }

        Collections.sort(tuple, (o1, o2) -> {
            if(o1.length < o2.length) return -1;
            else return 1;
        });
        answer = new int[tuple.size()];
        answer[0] = tuple.get(0)[0];
        for (int i = 1; i < tuple.size(); i++) {
            int[] curTuple = tuple.get(i);
            for (int j = 0; j < tuple.get(i).length; j++) {
                int cur = curTuple[j];
                boolean flag = false;
                for (int k = 0; k < i; k++) {
                    if(answer[k] == cur) flag = true;
                }
                if(!flag) answer[i] = cur;
            }
        }

        return answer;
    }
}
