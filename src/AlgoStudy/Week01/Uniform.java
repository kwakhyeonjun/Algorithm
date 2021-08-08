package AlgoStudy.Week01;

public class Uniform {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // 5
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3})); // 5
        System.out.println(solution(3, new int[]{3}, new int[]{1})); // 5
    }

    public static int solution(int n, int[] lost, int[] reserve){
        int[] uniform = new int[n+1];
        for(int i = 1; i <= n; i++){
            uniform[i] = 1;
        }
        for(int i = 0; i < lost.length; i++){
            uniform[lost[i]]--;
        }
        for(int i = 0; i < reserve.length; i++){
            uniform[reserve[i]]++;
        }
        for(int i = 1; i <= n; i++){
            if(uniform[i] == 0){
                if(i - 1 > 0 && uniform[i-1] == 2){
                    uniform[i-1]--;
                    uniform[i]++;
                }
                else if(i + 1 <= n && uniform[i+1] == 2){
                    uniform[i+1]--;
                    uniform[i]++;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < uniform.length; i++){
            if(uniform[i] >= 1) result++;
        }
        return result;
    }
}
