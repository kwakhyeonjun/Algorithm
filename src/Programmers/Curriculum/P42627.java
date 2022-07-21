package Programmers.Curriculum;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P42627 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        P42627 sol = new P42627();

        System.out.println(sol.solution(jobs));
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        Queue<Job> jobHeap = new PriorityQueue<>();

        for(int[] job : jobs) {
            jobHeap.add(new Job(job[0], job[1]));
        }

        int curTime = 0;

        while(!jobHeap.isEmpty()) {
            Job cur = jobHeap.poll();
            if(curTime > cur.input) {
                answer += curTime - cur.input;
            } else {
                curTime = cur.input;
            }
            answer += cur.size;
            curTime += cur.size;
        }

        double jobCount = jobs.length;
        answer = (int)Math.floor(answer/jobCount);

        return answer;
    }

    class Job implements Comparable<Job> {
        int input;
        int size;

        Job() {}

        Job(int input, int size) {
            this.input = input;
            this.size = size;
        }


        @Override
        public int compareTo(Job o) {
            if(this.input == o.input) {
                return o.size - this.size;
            }
            return o.input - this.input;
        }
    }
}
