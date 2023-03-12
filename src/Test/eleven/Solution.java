package Test.eleven;

public class Solution {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] A = {2, 1, 3, 5, 4};
        System.out.println(sol.solution1(A));
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        int answer = 100000001;
        int n = A.length;
        if(n < 2) return -2;
        for(int i = 0; i < n - 1; i++){
            answer = Math.min(answer, Math.abs(A[i] - A[i+1]));
        }
        if(answer > 100000000) return -1;
        return answer;
    }

    public int solution1(int[] A) {
        // write your code in Java SE 8

        int answer = 0;

        int n = A.length;

        boolean[] bulb = new boolean[n];

        int index = 0;

        for(int i = 0; i < n; i++){
            bulb[A[i] - 1] = true;
            boolean flag = false;
            for(int j = index; j < n; j++) {
                if(!bulb[j]) break;
                index = j + 1;
                flag = true;
            }
            if(flag) answer++;
        }

        return answer;
    }
}
