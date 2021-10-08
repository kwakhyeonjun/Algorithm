package Baekjoon.Grade.Silver;

import java.io.*;
import java.util.*;

public class B2667 {

    private static int N;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static List<Integer> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) == '1';
            }
        }

        answer = new ArrayList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] && !visited[i][j]) bfs(i, j);
            }
        }

        answer.sort(Comparator.naturalOrder());

        bw.write(answer.size() + "\n");
        for(int v: answer){
            bw.write(v + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if(map[nx][ny] && !visited[nx][ny]){
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        answer.add(count);
    }
}
