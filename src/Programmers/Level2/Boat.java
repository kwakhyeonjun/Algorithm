package Programmers.Level2;

import java.util.Arrays;

public class Boat {
    public static void main(String[] args) {
        Boat sol = new Boat();
        int[] people = {70, 50, 80};
        int limit = 100;
        System.out.println(sol.solution(people, limit));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--) {
            if(people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
}
