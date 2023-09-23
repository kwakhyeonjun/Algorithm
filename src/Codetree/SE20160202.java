package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE20160202 {
    private static final int MAX_N = 20;
    private static final int[][] map = new int[MAX_N][MAX_N];
    private static int[][] calMap = new int[MAX_N][MAX_N];
    private static int n, answer;
    private static int[] picked = new int[5];

    public static void main(String[] args) throws IOException {
        init();
        comb(0);
        System.out.println(answer);
    }

    private static void moveRight() {
        int[][] curMap = new int[MAX_N][MAX_N];
        for(int i = 0; i < n; i++) {
            int prev = 0;
            int y = n - 1;
            for(int j = n -1; j >= 0; j--) {
                if(calMap[i][j] == 0) continue;
                if(prev == 0) {
                    prev = calMap[i][j];
                    continue;
                }
                if(calMap[i][j] == prev) {
                    curMap[i][y--] = prev * 2;
                    prev = 0;
                } else {
                    curMap[i][y--] = prev;
                    prev = calMap[i][j];
                }
            }
            if(prev != 0) curMap[i][y] = prev;
        }
        calMap = curMap;
    }

    private static void moveLeft() {
        int[][] curMap = new int[MAX_N][MAX_N];
        for(int i = 0; i < n; i++) {
            int prev = 0;
            int y = 0;
            for(int j = 0; j < n; j++) {
                if(calMap[i][j] == 0) continue;
                if(prev == 0) {
                    prev = calMap[i][j];
                    continue;
                }
                if(calMap[i][j] == prev) {
                    curMap[i][y++] = prev * 2;
                    prev = 0;
                } else {
                    curMap[i][y++] = prev;
                    prev = calMap[i][j];
                }
            }
            if(prev != 0) curMap[i][y] = prev;
        }
        calMap = curMap;
    }

    private static void moveUp() {
        int[][] curMap = new int[MAX_N][MAX_N];
        for(int j = 0; j < n; j++) {
            int prev = 0;
            int x = 0;
            for(int i = 0; i < n; i++) {
                if(calMap[i][j] == 0) continue;
                if(prev == 0) {
                    prev = calMap[i][j];
                    continue;
                }
                if(calMap[i][j] == prev) {
                    curMap[x++][j] = prev * 2;
                    prev = 0;
                } else {
                    curMap[x++][j] = prev;
                    prev = calMap[i][j];
                }
            }
            if(prev != 0) curMap[x][j] = prev;
        }
        calMap = curMap;
    }

    private static void moveDown() {
        int[][] curMap = new int[MAX_N][MAX_N];
        for(int j = 0; j < n; j++) {
            int prev = 0;
            int x = n - 1;
            for(int i = n - 1; i >= 0; i--) {
                if(calMap[i][j] == 0) continue;
                if(prev == 0) {
                    prev = calMap[i][j];
                    continue;
                }
                if(calMap[i][j] == prev) {
                    curMap[x--][j] = prev * 2;
                    prev = 0;
                } else {
                    curMap[x--][j] = prev;
                    prev = calMap[i][j];
                }
            }
            if(prev != 0) curMap[x][j] = prev;
        }
        calMap = curMap;
    }

    private static void move(int d) {
        switch(d) {
            case 0:
                moveRight();
                break;
            case 1:
                moveLeft();
                break;
            case 2:
                moveDown();
                break;
            case 3:
                moveUp();
                break;
        }
//		printMap();
    }

    private static void printMap() {
        for(int i = 0;i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(calMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void findMax() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                answer = Math.max(answer, calMap[i][j]);
            }
        }
    }

    private static void calc() {
        for(int i =0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                calMap[i][j] = map[i][j];
            }
        }
        for(int i = 0; i < 5; i++) {
            move(picked[i]);
        }
        findMax();
    }

    private static void comb(int count) {
        if(count == 5) {
            calc();
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
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


    }
}

