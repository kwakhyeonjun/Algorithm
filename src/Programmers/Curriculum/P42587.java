package Programmers.Curriculum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P42587 {
    public static void main(String[] args) {
        P42587 sol = new P42587();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(sol.solution(priorities, location));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        while(true) {
            int[] cur = queue.poll();
            boolean isPriority = true;
            for(int[] s : queue) {
                if(cur[1] < s[1]) {
                    isPriority = false;
                    break;
                }
            }
            if(isPriority) {
                answer++;
                if(cur[0] == location) break;
            }else {
                queue.add(cur);
            }
        }
        return answer;
    }
}
