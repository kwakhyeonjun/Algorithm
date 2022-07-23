package Programmers.Curriculum;

import java.util.PriorityQueue;

public class P42628 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        P42628 sol = new P42628();
        int[] answer = sol.solution(operations);
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for(String operation : operations) {
            String[] cur = operation.split(" ");
            if("I".equals(cur[0])) {
                pq.offer(Integer.parseInt(cur[1]));
                max = Math.max(max, Integer.parseInt(cur[1]));
            } else {
                if(pq.isEmpty()) continue;
                if("1".equals(cur[1])){
                    pq.remove(max);
                    max = Integer.MIN_VALUE;
                } else {
                    pq.poll();
                }
            }
        }
        if(pq.isEmpty()) return new int[]{0, 0};
        return new int[]{max, pq.peek()};
    }
}
