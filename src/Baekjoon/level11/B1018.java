package Baekjoon.level11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1018 {
    private static int N, M, count, min = Integer.MAX_VALUE;
    private static int[][] search = {{1, 0}, {0, 1}}; // 아래 / 오른쪽
    private static char[][] map;
    private static char[][][] chess =
            {
                {
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
                },
                {
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
                }
            };
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
                isChess(map, i, j);
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void isChess(char[][] map, int x, int y){
        for(int c = 0; c < 2; c++){
            count = 0;
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(chess[c][i][j] != map[x + i][y + j]) count++;
                }
            }
            min = Math.min(min, count);
        }
    }
}
