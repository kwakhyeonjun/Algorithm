package Baekjoon.Grade.Silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B2606 {

    private static int N, answer;
    private static boolean[][] computers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());

        computers = new boolean[N + 1][N + 1];
        visited = new boolean[N+1];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a][b] = true;
            computers[b][a] = true;
        }

        bfs();
        System.out.println(answer);
        br.close();
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        answer = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 1; i < N+1; i++) {
                if(computers[cur][i] && !visited[i]){
                    queue.add(i);
                    answer++;
                    visited[i] = true;
                }
            }
        }
    }
}
