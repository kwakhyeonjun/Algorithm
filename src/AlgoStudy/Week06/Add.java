package AlgoStudy.Week06;

import java.util.*;

public class Add {
    public int[] solution(int[] numbers) {
        comb(numbers, new int[2], 0, 0);
        int[] answer = new int[result.size()];
        int idx = 0;
        for(int v : result){
            answer[idx++] = v;
        }
        Arrays.sort(answer);
        return answer;
    }

    Set<Integer> result = new HashSet<>();
    private void comb(int[] numbers, int[] picked, int start, int count){
        if(count == 2){
            result.add(picked[0] + picked[1]);
        }else{
            for(int i = start; i < numbers.length; i++){
                picked[count] = numbers[i];
                comb(numbers, picked, i+1, count+1);
            }
        }
    }
}
