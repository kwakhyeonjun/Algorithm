package AlgoStudy.Week02;

public class Toss_6 {
    private static int totCount;

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
    public static int solution(int numOfStairs){
        comb(new int[]{1, 2, 3}, numOfStairs, 0);
        return totCount;
    }

    private static void comb(int[] step, int numOfStairs, int count){
        if(numOfStairs == 0){
            totCount++;
            return;
        }else if(numOfStairs < 0){
            return;
        }else{
            for(int i= 0 ; i <step.length; i++){
                comb(step, numOfStairs - step[i], count+1);
            }
        }
    }
}
