package AlgoStudy.Week07;

import java.util.ArrayList;
import java.util.List;

public class SameNums {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] != arr[j]) break;
                i++;
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
