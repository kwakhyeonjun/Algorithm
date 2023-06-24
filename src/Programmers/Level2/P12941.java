package Programmers.Level2;

import java.util.Arrays;

public class P12941 {

    public static void main(String[] args) {
        P12941 sol = new P12941();


    }

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] + B[B.length - i - 1];
        }

        return answer;
    }
}
