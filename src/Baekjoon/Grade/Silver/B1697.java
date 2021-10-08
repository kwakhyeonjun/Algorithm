package Baekjoon.Grade.Silver;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class B1697 {

    private static final int MAX = 100001;
    private static int N, K;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if(K < N) System.out.println(N-K);
        else if(K == N) System.out.println(0);
        else System.out.println(bfs());
    }

    private static int[] dist;

    private static int bfs(){
        dist = new int[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            int forward = cur+1;
            int backward = cur-1;
            int jump = cur*2;

            if(forward == K || backward == K || jump == K){
                return dist[cur] + 1;
            }

            if(forward >= 0 && forward < MAX && dist[forward] == 0){
                queue.add(forward);
                dist[forward] = dist[cur] + 1;
            }

            if(backward >= 0 && backward < MAX && dist[backward] == 0){
                queue.add(backward);
                dist[backward] = dist[cur] + 1;
            }

            if(jump >= 0 && jump < MAX && dist[jump] == 0){
                queue.add(jump);
                dist[jump] = dist[cur] + 1;
            }
        }
        return -1;
    }
}
