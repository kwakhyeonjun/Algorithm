package Programmers.Curriculum;

import java.util.Arrays;

public class P42746 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        P42746 sol = new P42746();
        System.out.println(sol.solution(numbers));
    }

    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) strNumbers[i] = String.valueOf(numbers[i]);
        Arrays.sort(strNumbers, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        if("0".equals(strNumbers[0])) return "0";
        return String.join("", strNumbers);
    }
}
