package AlgoStudy.Week09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumArray {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(num%divisor == 0) list.add(num);
        }

        if(list.size() == 0) return new int[]{-1};

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
