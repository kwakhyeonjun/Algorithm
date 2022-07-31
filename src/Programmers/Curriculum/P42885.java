package Programmers.Curriculum;

import java.util.Arrays;

public class P42885 {
    public static void main(String[] args) {
        P42885 sol = new P42885();
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(sol.solution(people, limit));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int sum = 0;
        for(int i = people.length - 1; i >= 0; i--) {
            if(sum + people[i] > limit) {
                answer++;
                sum = 0;
            }
            sum += people[i];
        }
        return answer + 1;
    }
}
