package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SE201901AM02 {

    private static final int MAX_N = 100, MAX_M = 100;
    private static final int[][][] map = new int[MAX_N][MAX_M][3];
    private static final List<int[]> mold = new ArrayList<>();
    private static final Map<String, int[]> temp = new HashMap<>();

    private static final int[][] dir = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int n, m, answer;


    private static void addMap() {
        for(String key : temp.keySet()) {
            int[] cur = temp.get(key);

            map[cur[0]][cur[1]] = new int[] {cur[2], cur[3], cur[4]};
        }
    }

    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private static void setMold() {
        temp.clear();
        mold.clear();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j][2] != 0) {
                    int[] cur = map[i][j];
                    mold.add(new int[] {i, j, cur[0], cur[1], cur[2]});
                    map[i][j] = new int[] {0, 0, 0};
                }
            }
        }
    }

    private static void move(int[] mold) {
        int x = mold[0];
        int y = mold[1];
        int s = mold[2];
        int d = mold[3];
        int b = mold[4];

        for(int i = 0; i < s; i++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(isOutRange(nx, ny)) {
                if(d == 1) d = 2;
                else if(d == 2) d = 1;
                else if(d == 3) d = 4;
                else d = 3;

                nx = x + dir[d][0];
                ny = y + dir[d][1];
            }

            x = nx;
            y = ny;
        }

        String key = x + " " + y;

        if(temp.containsKey(key)) {
            int[] prev = temp.get(key);

            if(prev[4] > b) {
                return;
            }
        }

        temp.put(key, new int[] {x, y, s, d, b});
    }

    private static void moveMold() {
        setMold();
        for(int[] cur : mold) {
            move(cur);
        }
        addMap();
    }

    private static void find(int row) {
        for(int i = 0; i < n; i++) {
            if(map[i][row][2] != 0) {
//				System.out.println("find = " + map[i][row][2]);
                answer += map[i][row][2];
                map[i][row] = new int[] {0, 0, 0};
                return;
            }
        }
    }

    private static void simulation() {
        for(int i = 0; i < m; i++) {
            find(i);
            moveMold();
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        for(int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            int s = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);
            int b = Integer.parseInt(input[4]);

            map[x][y] = new int[] {s, d, b};
        }


    }

    public static void main(String[] args) throws IOException {
        init();

        simulation();

        System.out.println(answer);
    }
}
