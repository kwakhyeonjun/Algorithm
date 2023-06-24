package Programmers.ret;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                if(nx == n - 1 && ny == m - 1) return cur[2] + 1;

                queue.add(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}
