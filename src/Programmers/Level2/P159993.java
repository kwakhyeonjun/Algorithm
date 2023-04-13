package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class P159993 {
    public static void main(String[] args) {
        P159993 sol = new P159993();
        sol.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
    }

    public int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();
        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(maps[i].charAt(j) != 'X') map[i][j] = true;
                if(maps[i].charAt(j) == 'S') start = new int[]{i, j};
                else if (maps[i].charAt(j) == 'E') end = new int[]{i, j};
                else if (maps[i].charAt(j) == 'L') lever = new int[]{i, j};
            }
        }

        visited = new boolean[n][m];
        int first = bfs(start, lever);
        if(first == -1) return -1;

        visited = new boolean[n][m];
        int sec = bfs(lever, end);
        if(sec == -1) return -1;

        return first + sec;
    }

    private int bfs(int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(!map[nx][ny]) continue;

                if(nx == end[0] && ny == end[1]) return cur[2] + 1;

                queue.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }

    private int n, m;
    private boolean[][] map;
    private boolean[][] visited;
    private int[] start;
    private int[] end;
    private int[] lever;
    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}
