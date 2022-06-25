package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class Zip {
    public static void main(String[] args) {
        Zip sol = new Zip();
        String msg = "KAKAO";
        int[] answer = sol.solution(msg);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("");
        for (int i = 0; i < 26; i++) {
            dictionary.add(String.valueOf((char)('A' + i)));
        }

        StringBuilder sb = null;
        for(int i = 0; i < msg.length(); i++) {
            sb = new StringBuilder();
            sb.append(msg.charAt(i));
            int idx = 1;
            int cur = dictionary.indexOf(sb.toString());
            while(dictionary.contains(sb.toString()) && i + idx < msg.length()){
                cur = dictionary.indexOf(sb.toString());
                sb.append(msg.charAt(i + idx++));
            }
            if(i + idx >= msg.length()) {
                if(dictionary.contains(sb.toString())){
                    answerList.add(dictionary.indexOf(sb.toString()));
                    break;
                }
            }
            if(sb.length() != 1) {
                i += idx - 2;
                dictionary.add(sb.toString());
            }
            answerList.add(cur);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
