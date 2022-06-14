package Programmers.Level2;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        HIndex sol = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(sol.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
