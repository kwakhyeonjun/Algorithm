package IM;

import java.util.Scanner;

public class B10163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[1001][1001];
        for(int t = 1; t <= N; t++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            for(int i = x; i < x + w; i++){
                for(int j = y; j < y + h; j++){
                    map[i][j] = t;
                }
            }
        }

        int[] paper = new int[N+1];
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < 1001; j++){
                if(map[i][j] != 0) paper[map[i][j]]++;
            }
        }
        for(int i = 1; i <= N; i++){
            System.out.println(paper[i]);
        }
    }
}
