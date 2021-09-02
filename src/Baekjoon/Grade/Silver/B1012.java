package Baekjoon.Grade.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
    private static int N, M, K, cnt;
    private static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = true;
            }
            cnt = 0;
            for(int i = 0; i < N; i++){
                for (int j = 0; j < M; j++) {
                    if(map[i][j]){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static void dfs(int x, int y){
        map[x][y] = false;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(isInMap(nx, ny) && map[nx][ny]) dfs(nx, ny);
        }
    }

    private static boolean isInMap(int x, int y){
        return x>=0 && x < N && y >= 0 && y < M;
    }
}
