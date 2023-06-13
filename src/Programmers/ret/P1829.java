package Programmers.ret;

import java.util.LinkedList;
import java.util.Queue;

public class P1829 {
    private int m, n;
    private int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.picture = picture;

        int[] answer = new int[2];
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                if(picture[i][j] == 0) continue;

                int cur = bfs(i, j);
                answer[0]++;
                answer[1] = Math.max(answer[1], cur);
            }
        }

        return answer;
    }

    private boolean[][] visited;
    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int bfs(int x, int y) {
        int ret = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;
                if(picture[nx][ny] != picture[x][y]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                ret++;
            }
        }

        return ret;
    }
}
