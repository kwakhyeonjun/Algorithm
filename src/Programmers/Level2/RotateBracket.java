package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateBracket {
    public static void main(String[] args) {
        RotateBracket sol = new RotateBracket();
        String s = "}]()[{";
        int answer = sol.solution(s);
        System.out.println(answer);
    }

    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.add(c);
        }
        for (int i = 0; i < s.length(); i++) {
            Queue<Character> curQueue = new LinkedList<>();
            curQueue.addAll(queue);
            Stack<Character> stack = new Stack<>();
            while(!curQueue.isEmpty()){
                if(stack.isEmpty()) {
                    stack.add(curQueue.poll());
                }
                if(curQueue.isEmpty()) break;
                char cur = curQueue.poll();
                char prev = stack.pop();

                if((prev == '{' && cur == '}')
                    || (prev == '(' && cur == ')')
                    || (prev == '[' && cur == ']')) continue;

                stack.add(prev);
                stack.add(cur);
            }
            if(stack.isEmpty()) answer++;
            queue.add(queue.poll());
        }
        return answer;
    }
}
