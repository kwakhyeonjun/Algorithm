package Baekjoon.Grade.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

    private static boolean[][] map;
    private static boolean[][] visited;
    private static int n, m, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new boolean[n][m];
        for(int i = 0;i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                if(input.charAt(j) == '1'){
                    map[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(min);
        br.close();
    }

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            if(x == n-1 && y == m-1){
                min = count;
                return;
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(isInMap(nx, ny) && !visited[nx][ny] && map[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count+1});
                }
            }
        }
    }

    private static boolean isInMap(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
