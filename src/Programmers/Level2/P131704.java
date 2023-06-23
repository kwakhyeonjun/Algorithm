package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P131704 {
    public int solution(int[] order) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= order.length; i++) {
            queue.add(i);
        }

        int index = 0;

        for(int cur : queue) {
            while(!stack.isEmpty() && stack.peek() == order[index]) {
                answer++;
                index++;
                stack.pop();
            }

            if(cur < order[index]) {
                stack.push(cur);
                continue;
            }
            if(cur == order[index]) {
                index++;
                answer++;
                continue;
            }
        }
        while(!stack.isEmpty() && stack.peek() == order[index]) {
            answer++;
            index++;
            stack.pop();
        }

        return answer;
    }
}
