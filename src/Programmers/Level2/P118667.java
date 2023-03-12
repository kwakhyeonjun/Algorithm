package Programmers.Level2;

import java.util.Arrays;
import java.util.Queue;

public class P118667 {

    public static void main(String[] args) {
        int[] queue = {1, 2, 3};
        P118667 sol = new P118667();
        Queue ans = sol.pop(queue);
        System.out.println(Arrays.toString(queue));
    }

//    private Queue add(int[] queue, int val) {
//        int[] newQueue = new int[queue.length];
//        System.arraycopy(queue, 0, newQueue, 0, queue.length);
//    }

    private Queue pop(int[] queue) {
        int res = queue[0];
        int[] newQueue = new int[queue.length - 1];
        for(int i = 1; i < queue.length; i++) {
            newQueue[i - 1] = queue[i];
        }
        return new Queue(res, newQueue);
    }

    private class Queue {
        int res;
        int[] queue;

        Queue() { }
        Queue(int res, int[] queue) {
            this.res = res;
            this.queue = queue;
        }
    }
}
