package Baekjoon.level11;

import java.io.*;
import java.util.StringTokenizer;

public class B1018 {
    private static int N, M, count, min = Integer.MAX_VALUE;
    private static int[][] search = {{1, 0}, {0, 1}}; // 아래 / 오른쪽
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        for(int i = 0; i <= N-8; i++){
            for(int j = 0; j <= M - 8; j++){
                count = 0;
                isChess(i, j);
                min = Math.min(min, count);
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void isChess(int x, int y){
        for(int i = x; i < x + 8; i++){
            for(int j = y; j < y + 8; j++){
                isColored(i, j);
            }
        }
    }

    private static void isColored(int x, int y){
        for(int i = 0; i < 2; i++){
            int nx = x + search[i][0];
            int ny = x + search[i][1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[x][y] == 'B'){
                if(map[nx][ny] == 'B') count++;
            }else{
                if(map[nx][ny] == 'W') count++;
            }
        }
    }
}
