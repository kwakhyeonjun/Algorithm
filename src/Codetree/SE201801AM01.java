package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SE201801AM01 {
    static class Chess {
        int x;
        int y;
        int kind;

        public Chess(int x, int y, int kind) {
            this.x = x;
            this.y = y;
            this.kind = kind;
        }
    }

    private static final int MAX_N = 8, MAX_M = 8;
    private static int[][] map = new int[MAX_N][MAX_M];
    private static int[][] tempMap = new int[MAX_N][MAX_M];

    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[][] chessDir = {{}, {0}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3}};

    private static int n, m, size, answer = MAX_N * MAX_M;
    private static List<Chess> mine = new ArrayList<>();
    private static List<Chess> opponent = new ArrayList<>();
    private static int[] picked;

    private static void countEmptyPlace() {
//		System.out.println("count: ");
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
//				System.out.print(tempMap[i][j] + " ");
                if(tempMap[i][j] == 0) count++;
            }
//			System.out.println();
        }
//		System.out.println("count = " + count);
        answer = Math.min(answer, count);
    }

    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private static void move() {
        for(int i = 0; i < size; i++) {
            Chess chess = mine.get(i);
            int[] curChessDir = new int[chessDir[chess.kind].length];
//			System.out.println("chess = " + chess.kind);
//			System.out.print("chess Dir = ");
            for(int j = 0; j < curChessDir.length; j++) {
                curChessDir[j] = (chessDir[chess.kind][j] + picked[i]) % 4;
//				System.out.print(curChessDir[j] + " ");
            }
//			System.out.println();


            for(int d : curChessDir) {
                int dx = dir[d][0];
                int dy = dir[d][1];

                int nx = chess.x;
                int ny = chess.y;

                while(true) {
//					System.out.println("nx = " + nx);
//					System.out.println("ny = " + ny);
                    if(isOutRange(nx, ny)) break;
                    if(map[nx][ny] == 6) break;

                    tempMap[nx][ny] = chess.kind;

                    nx += dx;
                    ny += dy;
                }
            }
        }
    }

    private static void setOpponent() {
        for(Chess chess : opponent) {
            tempMap[chess.x][chess.y] = 6;
        }
    }

    private static void clearTempMap() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                tempMap[i][j] = 0;
            }
        }
    }

    private static void simulation() {
        clearTempMap();
        setOpponent();
        move();
        countEmptyPlace();
    }

    private static void comb(int count) {
        if(count == size) {
            simulation();
            return;
        }
        for(int i = 0; i < 4; i++) {
            picked[count] = i;
            comb(count + 1);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 0) continue;
                else if(map[i][j] == 6) opponent.add(new Chess(i, j, map[i][j]));
                else mine.add(new Chess(i, j, map[i][j]));
            }
        }

        size = mine.size();
        picked = new int[size];
    }

    public static void main(String[] args) throws IOException {
        init();
        comb(0);

        System.out.println(answer);
    }
}
