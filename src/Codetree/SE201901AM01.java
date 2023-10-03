package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE201901AM01 {
    private static final int MAX_N = 50, MAX_M = 50;
    private static final int[][] map = new int[MAX_N][MAX_M];
    private static final int[][] tempMap = new int[MAX_N][MAX_M];
    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int[][][] cleanDir = {{{0, 1}, {-1, 0}, {0, -1}, {1, 0}},
            {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}};

    private static int n, m, t;
    private static int up, down;

    private static void count() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == -1) continue;
                count += map[i][j];
            }
        }

        System.out.println(count);
    }

    private static void clean() {
        for(int i = 0; i < 2; i++) {
            int prev = 0;
            int x = i == 0 ? up : down;
            int y = 0;
            int idx = 0;

            while(true) {
                int nx = x + cleanDir[i][idx][0];
                int ny = y + cleanDir[i][idx][1];

                if(isOutRange(nx, ny)) {
                    idx++;
                    continue;
                }

                if(map[nx][ny] == -1) break;

                int temp = prev;
                prev = map[nx][ny];
                map[nx][ny] = temp;

                x = nx;
                y = ny;
            }
        }
    }

    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    /**
     * 먼지가 인접한 4방향의 상하좌우 칸으로 확산됩니다.
     */
    private static void dustMove() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] <= 0) continue;

                int rest = map[i][j];
                int diffusion = map[i][j] / 5;
                for(int[] d : dir) {
                    int nx = i + d[0];
                    int ny = j + d[1];

                    //a. 인접한 방향에 시공의 돌풍이 있거나, 방의 범위를 벗어난다면 해당 방향으로는 확산이 일어나지 않습니다.
                    if(isOutRange(nx, ny)) continue;
                    if(map[nx][ny] == -1) continue;

                    tempMap[nx][ny] += diffusion;
                    rest -= diffusion;
                }
                tempMap[i][j] += rest;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == -1) continue;
                map[i][j] = tempMap[i][j];
            }
        }
    }

    private static void tempMapClear() {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempMap[i][j] = 0;
            }
        }
    }

    private static void dust() {
        tempMapClear();
        dustMove();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == -1 && up == 0) up = i;
                else if(map[i][j] == -1 && up != 0) down = i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        for(int time = 0; time < t; time++) {
            dust();
            clean();
        }

        count();
    }
}
