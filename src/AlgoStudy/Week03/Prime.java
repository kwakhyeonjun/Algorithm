package AlgoStudy.Week03;

public class Prime {
    static int answer = 0;
    public int solution(int[] nums) {
        int[] result = new int[3];
        comb(nums, result, 0, 0);
        return answer;
    }

    private static void comb(int[] nums, int[] result, int start, int count){
        if(count == 3){
            int sum = 0;
            for(int v : result) sum += v;
            if(isPrime(sum)) answer++;
            return;
        }else{
            for(int i = start; i < nums.length; i++){
                result[count] = nums[i];
                comb(nums, result, i+1, count+1);
            }
        }
    }

    private static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
