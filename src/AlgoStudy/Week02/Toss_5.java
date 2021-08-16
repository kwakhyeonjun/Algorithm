package AlgoStudy.Week02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Toss_5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{30, 40, 10, 20, 30}, 3)));
    }
    public static int[] solution(int[] fruitWeights, int k){
        Set<Integer> score = new HashSet<>();
        for(int i = 0; i < fruitWeights.length - k + 1; i++){
            int max = 0;
            for(int j = i; j < i + k; j++){
                max = Math.max(max, fruitWeights[j]);
            }
            score.add(max);
        }
        int[] answer = new int[score.size()];
        int i = 0;
        for(int v : score){
            answer[i++] = v;
        }
        return answer;
    }
}
