package IM;

import java.util.Scanner;

public class B2567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] map = new boolean[101][101];
        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int i = x; i < x+10; i++){
                for (int j = y; j < y+10; j++) {
                    map[i][j] = true;
                }
            }
        }

        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int count = 0;
        for(int i = 1; i < 101; i++){
            for(int j = 1; j < 101; j++){
                if(map[i][j]){
                    for(int d = 0; d < 4; d++){
                        int nx = i + dir[d][0];
                        int ny = j + dir[d][1];
                        if(isInMap(nx, ny) && !map[nx][ny]) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isInMap(int x, int y){
        return (x >= 0 && x < 101 && y >= 0 && y < 101);
    }
}
