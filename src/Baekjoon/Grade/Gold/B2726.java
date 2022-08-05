package Baekjoon.Grade.Gold;

import AlgoStudy.Week05.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B2726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new boolean[n][n];
            stack = new Stack<>();

            setChess(map, 0);
            System.out.println(max);
            for(int[] cur : stack) {
                System.out.println(cur[0] + " " + cur[1]);
            }
        }
    }

    private static int n, max;
    private static boolean[][] map;
    private static Stack<int[]> stack;

    private static void setChess(boolean[][] map, int count){
        for(int i = count; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(!isPos(map, i, j)) continue;
                map[i][j] = true;
                stack.add(new int[]{i, j});
                setChess(map, count);
                map[i][j] = false;
                stack.pop();
            }
        }
        max = Math.max(count, max);
    }

    private static boolean isPos(boolean[][] map, int x, int y) {
        // 가로
        for(int i = 0; i < x; i++) {
            if(map[x][i]) return false;
        }

        for(int i = y; i < n; i++) {
            if(map[i][y]) return false;
        }

        for(int i = 0, j = 0; i < n || j < n; i++, j++) {
            if(map[i][j]) return false;
        }

        return true;
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
