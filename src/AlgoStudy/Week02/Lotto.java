package AlgoStudy.Week02;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int right = 0;
        int wrong = 0;
        int max = 6;
        int min = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) continue;
            boolean isRight = false;
            for(int j = 0; j < win_nums.length; j++){
                if(win_nums[j] == lottos[i]){
                    right++;
                    isRight = true;
                }
            }
            if(!isRight) wrong++;
        }
        min += right;
        max -= wrong;
        int[] result = {getRank(max), getRank(min)};
        return result;
    }
    private static int getRank(int num){
        if(num == 6) return 1;
        else if(num == 5) return 2;
        else if(num == 4) return 3;
        else if(num == 3) return 4;
        else if(num == 2) return 5;
        else return 6;
    }
}
