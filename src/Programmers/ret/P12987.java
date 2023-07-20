package Programmers.ret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P12987 {
    public static void main(String[] args) {
        P12987 sol = new P12987();
        int answer = sol.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1});
        System.out.println(answer);

    }

    public int betterSolution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if(A[i] < B[j]) {
                answer++;
                j--;
            }
        }

        return answer;
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        int start = 0;
        int end = B.length - 1;

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            listA.add(A[i]);
            listB.add(B[i]);
        }

        listA.sort(Collections.reverseOrder());
        listB.sort(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            if(listA.get(i) >= listB.get(start)) {
                end--;
            } else {
                answer++;
                start++;
            }
        }

        return answer;
    }
}
