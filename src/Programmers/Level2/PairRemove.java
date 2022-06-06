package Programmers.Level2;

import java.util.Stack;

public class PairRemove {
    public static void main(String[] args) {
        PairRemove sol = new PairRemove();
        String s = "baabaa";
        int answer = sol.solution(s);
        System.out.println(answer);
    }

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(stack.isEmpty()) {
                stack.add(cur);
                continue;
            }
            char prev = stack.pop();

            if(prev != cur) {
                stack.push(prev);
                stack.push(cur);
            }
        }
        return stack.isEmpty()?1:0;
    }
}
