package Baekjoon.Grade.Gold;

import AlgoStudy.Week05.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new boolean[n][n];


        }
    }

    private static int n;
    private static boolean[][] map;

    private static void setChess(boolean[][] map, int count){
        if(count == map.length) {

            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(map[i][j]) continue;
                boolean[][] copyMap = copyMap(map);
                map[i][j] = true;
                setMap(map, i, j);
            }
        }
    }

    private static void setMap(boolean[][] map, int x, int y) {
        // 가로
        for(int i = 0; i < x; i++) {
            map[x][i] = true;
        }
    }

    private static boolean[][] copyMap(boolean[][] map) {
        boolean[][] copyMap = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }
}
