package Programmers.Level2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        Printer sol = new Printer();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = sol.solution(priorities, location);
        System.out.println(answer);
    }

    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            Iterator<int[]> iter = queue.iterator();
            boolean flag = false;
            while(iter.hasNext()) {
                int[] next = iter.next();
                if(next[0] > cur[0]) {
                    flag = true;
                    break;
                }
            }
            if(flag) queue.add(cur);
            else {
                if(cur[1] == location) break;
                answer++;
            }
        }
        return answer;
    }
}
