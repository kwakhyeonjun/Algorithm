package AlgoStudy.Week05;

import java.util.Arrays;

public class budget {

    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int i = 0; i < d.length; i++){
            if(budget - d[i] >= 0) {
                budget -= d[i];
                answer++;
            }
            else continue;
        }

        return answer;
    }
}
