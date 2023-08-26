package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SE201701PM02 {
    private static final int MAX_N = 8, MAX_M = 8;
    private static final int[][] map = new int[MAX_N][MAX_M];
    private static final List<int[]> empty = new ArrayList<>();
    private static final List<int[]> fire = new ArrayList<>();
    private static final Queue<int[]> queue = new LinkedList<>();
    private static final int[][] picked = new int[3][2];
    private static final boolean[][] visited = new boolean[MAX_N][MAX_M];
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int n, m, answer;

    private static void removeWall() {
        for (int[] cur : picked) {
            map[cur[0]][cur[1]] = 0;
        }
    }

    private static void setFire() {
        queue.addAll(fire);
    }
    private static void setWall() {
        for (int[] cur : picked) {
            map[cur[0]][cur[1]] = 1;
        }
    }

    private static void initVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if(isOutRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    private static void calc() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                if(map[i][j] != 0) continue;
                count++;
            }
        }
        answer = Math.max(answer, count);
    }

    private static void getArea() {
        initVisited();
        setWall();
        setFire();

        bfs();

        calc();
        removeWall();
    }

    private static void comb(int start, int count) {
        if(count == 3) {
            getArea();
            return;
        }
        for (int i = start; i < empty.size(); i++) {
            picked[count] = empty.get(i);
            comb(i + 1, count + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] == 0) empty.add(new int[]{i, j});
                if(map[i][j] == 2) fire.add(new int[]{i, j});
            }
        }

        comb(0, 0);

        System.out.println(answer);
    }
}