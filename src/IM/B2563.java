package IM;

import java.util.Scanner;

public class B2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] map = new int[101][101];
        for(int t = 0; t < T; t++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int i = x; i < x+10; i++){
                for(int j = y; j < y+10; j++){
                    map[i][j]++;
                }
            }
        }

        int count = 0;
        for(int i = 1; i < 101; i++){
            for(int j = 1; j < 101; j++){
                if(map[i][j] != 0) count++;
            }
        }
        System.out.println(count);
    }
}
