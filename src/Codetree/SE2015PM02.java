package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SE2015PM02 {
    private static final int MAX_N = 10, MAX_M = 10;
    private static final char[][] map = new char[MAX_N][MAX_M];
    // r d l u
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int n, m;
    private static int[] red, blue, goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        // init map
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'R') {
                    red = new int[]{i, j};
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    blue = new int[]{i, j};
                    map[i][j] = '.';
                } else if (map[i][j] == 'O') {
                    goal = new int[]{i, j};
                    map[i][j] = '.';
                }
            }
        }

        // rot map
        int answer = bfs();

        System.out.println(answer);
    }

    private static int bfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(red, blue, -1, 0));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                red = cur.nr;
                blue = cur.nb;
                if (i == 0) { // right
                    if (cur.pd == 0 || cur.pd == 2) continue;
                    if (red[1] < blue[1]) {
                        moveBlueFirst(dir[i]);
                    } else {
                        moveRedFirst(dir[i]);
                    }
                } else if (i == 1) { // down
                    if (cur.pd == 1 || cur.pd == 3) continue;
                    if(red[0] < blue[0]) {
                        moveBlueFirst(dir[i]);
                    } else {
                        moveRedFirst(dir[i]);
                    }
                } else if (i == 2) { // left
                    if (cur.pd == 0 || cur.pd == 2) continue;
                    if(red[1] < blue[1]) {
                        moveRedFirst(dir[i]);
                    } else {
                        moveBlueFirst(dir[i]);
                    }
                } else { // up
                    if (cur.pd == 1 || cur.pd == 3) continue;
                    if(red[0] < blue[0]) {
                        moveRedFirst(dir[i]);
                    } else {
                        moveBlueFirst(dir[i]);
                    }
                }
                Pos next = new Pos(red, blue, i, cur.count + 1);
//                System.out.println("next = " + next);
                if(isSamePosition(blue, goal)) continue;
                if(isSamePosition(red, goal)) return cur.count + 1;

                if(cur.count + 1 >= 10) continue;


                queue.add(next);
            }
        }
        return -1;
    }

    private static void moveRedFirst(int[] d) {
        red = move(red, d);
        blue = move(blue, d);
    }

    private static void moveBlueFirst(int[] d) {
        blue = move(blue, d);
        red = move(red, d);
    }

    static class Pos {
        int[] nr;
        int[] nb;
        int pd;
        int count;

        public Pos(int[] nr, int[] nb, int pd, int count) {
            this.nr = nr;
            this.nb = nb;
            this.pd = pd;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "nr=" + Arrays.toString(nr) +
                    ", nb=" + Arrays.toString(nb) +
                    ", pd=" + pd +
                    ", count=" + count +
                    '}';
        }
    }

    private static int[] move(int[] ball, int[] d) {
        int nx = ball[0];
        int ny = ball[1];
        while(true) {
            int tx = nx + d[0];
            int ty = ny + d[1];

            if(isOutRange(tx, ty)) break;
            if(map[tx][ty] == '#') break;
            if(isSamePosition(goal, tx, ty)) return new int[]{tx, ty};
            if(isSamePosition(red, tx, ty) || isSamePosition(blue, tx, ty)) break;

            nx = tx;
            ny = ty;
        }

        return new int[]{nx, ny};
    }

    private static boolean isSamePosition(int[] ball, int[] pos) {
        return isSamePosition(ball, pos[0], pos[1]);
    }
    private static boolean isSamePosition(int[] ball, int x, int y) {
        return ball[0] == x && ball[1] == y;
    }
    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
