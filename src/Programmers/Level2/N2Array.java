package Programmers.Level2;

public class N2Array {
    public static void main(String[] args) {
        N2Array sol = new N2Array();
        int n = 3;
        long left = 2, right = 5;
        int[] answer = sol.solution(n, left, right);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];

        int[] leftXY = findXY(n, left);
        int[] rightXY = findXY(n, right);

        int index = 0;
        for (int i = leftXY[0]; i <= rightXY[0]; i++) {
            if(i == leftXY[0]) {
                for (int j = leftXY[1]; j < (rightXY[0] == leftXY[0]?rightXY[1] + 1:n); j++) {
                    answer[index++] = Math.max(i, j) + 1;
                }
            }else if(i == rightXY[0]) {
                for (int j = 0; j <= rightXY[1]; j++) {
                    answer[index++] = Math.max(i, j) + 1;
                }
            }else{
                for (int j = 0; j < n; j++) {
                    answer[index++] = Math.max(i, j) + 1;
                }
            }
        }
        return answer;
    }

    private int[] findXY(int n, long pos) {
        for (long i = n - 1; i >= 0; i--) {
            if(n * i <= pos) {
                long x = i;
                long y = pos - x * n;
                return new int[]{(int)x, (int)y};
            }
        }
        return new int[]{-1, -1};
    }
}
