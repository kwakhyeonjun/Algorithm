package Programmers.Curriculum;

import java.util.Stack;

public class P42883 {
    public static void main(String[] args) {
        P42883 sol = new P42883();
        String number = "4177252841";
        System.out.println(sol.solution(number, 4));
    }

    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while(!stack.isEmpty() && c > stack.peek() && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
