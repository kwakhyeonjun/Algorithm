package AlgoStudy.Week08;

public class TargetNumber {
    public static void main(String[] args) {
        TargetNumber sol = new TargetNumber();
        int ans = sol.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(ans);
    }

    public int solution(int[] numbers, int target){
        sign = new boolean[numbers.length];
        comb(numbers, target, 0, 0);
        return answer;
    }

    private static int answer = 0;
    private static boolean[] sign;

    private static void comb(int[] numbers, int target, int count, int start){
        if(count == numbers.length){
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if(sign[i]) sum -= numbers[i];
                else sum += numbers[i];
            }
            if(sum == target) answer++;
        }else{
            for (int i = start; i < numbers.length; i++) {
                comb(numbers, target, count + 1, i + 1);
                sign[i] = true;
                comb(numbers, target, count + 1, i + 1);
                sign[i] = false;
            }
        }
    }
}
