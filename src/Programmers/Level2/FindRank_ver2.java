package Programmers.Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindRank_ver2 {
    public static void main(String[] args) {
        FindRank_ver2 sol = new FindRank_ver2();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = sol.solution(info, query);
        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    HashMap<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String i : info) {
            String[] cur = i.split(" ");
            makeSentence(cur, "", 0);
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] cur = query[i].split(" ");
            answer[i] = map.containsKey(cur[0]) ? binarySearch(cur[0], Integer.parseInt(cur[1])) : 0;
        }
        return answer;
    }

    private int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start;
    }

    private void makeSentence(String[] info, String key, int count) {
        if(count == 4) {
            if (!map.containsKey(key)) {
                List<Integer> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(Integer.parseInt(info[4]));
            return;
        }
        makeSentence(info, key + "-", count + 1);
        makeSentence(info, key + info[count], count + 1);
    }

}
