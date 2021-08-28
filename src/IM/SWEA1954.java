package IM;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SWEA1954 {
    private static int N;
    private static int[][] map;
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            map = new int[N][N];
            int idx = 1;
            int x = 0, y = 0, d = 0;
            while(idx <= N*N){
                map[x][y] = idx++;
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if(isNotInMap(nx, ny)){
                    d = (d+1)%4;
                    nx = x + dir[d][0];
                    ny = y + dir[d][1];
                }
                x = nx;
                y = ny;
            }
            bw.write("#" + test_case + "\n");
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    bw.write(map[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean isNotInMap(int x, int y){
        return (x < 0 || x >= N || y < 0 || y >= N || map[x][y] != 0);
    }
}
