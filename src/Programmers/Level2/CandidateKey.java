package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {
    public static void main(String[] args) {

        CandidateKey sol = new CandidateKey();

        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int answer = sol.solution(relation);
        System.out.println(answer);
    }


    public int solution(String[][] relation) {
        this.relation = relation;
        c = relation.length;
        r = relation[0].length;
        answer = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            visited = new boolean[r];
            picked = new int[i + 1];
            comb(0, 0, i + 1);
        }


        return answer.size();
    }

    private int c, r;
    private boolean[] visited;
    private int[] picked;
    private String[][] relation;
    private List<Integer> answer;

    private void comb(int start, int count, int size) {
        if(count == size){
            List<Integer> result = new ArrayList<>();
            for(int num : picked) result.add(num);

            if(isSubKey(result)) {
                int cur = 0;
                for(int num : result) {
                    cur |= 1 << (num);
                }
                if(!isSubSet(cur)) {
                    answer.add(cur);
                }
            }
            return;
        }
        for (int i = start; i < r; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            picked[count] = i;
            comb(i + 1, count + 1, size);
            visited[i] = false;
        }
    }

    private boolean isSubKey(List<Integer> rowList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < c; i++) {
            String data = "";
            for(int row : rowList) {
                data += relation[i][row];
            }
            if(set.contains(data)) {
                return false;
            }
            set.add(data);
        }
        return true;
    }

    private boolean isSubSet(int cur) {
        for(int i = 0; i < answer.size(); i++) {
            int ansData = answer.get(i);
            if((ansData & cur) == ansData) return true;
        }
        return false;
    }
}
