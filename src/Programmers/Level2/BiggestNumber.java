package Programmers.Level2;

import java.util.Arrays;

public class BiggestNumber {
    public static void main(String[] args) {
        BiggestNumber sol = new BiggestNumber();
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = sol.solution(numbers);
        System.out.println(answer);
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        if(stringNumbers[0].equals("0")) return "0";

        return String.join("", stringNumbers);
    }
}
