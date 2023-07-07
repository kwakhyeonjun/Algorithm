package Programmers.ret;

import java.util.Arrays;

public class P12941 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - i - 1];
        }
        return sum;
    }
}
