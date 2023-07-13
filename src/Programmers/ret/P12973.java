package Programmers.ret;

import java.util.Stack;

public class P12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char cur : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            char prev = stack.pop();
            if(prev != cur) {
                stack.push(prev);
                stack.push(cur);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
