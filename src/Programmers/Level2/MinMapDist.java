package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class MinMapDist {
    public static void main(String[] args) {
        MinMapDist sol = new MinMapDist();
        int[][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int answer = sol.solution(map);
        System.out.println(answer);
    }

    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        visited = new boolean[R][C];
        answer = Integer.MAX_VALUE;
        bfs(maps, 0, 0);
        return answer==Integer.MAX_VALUE?-1:answer;
    }

    private int R, C;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    private int answer;


    private void dfs(int[][] map, int x, int y, int count) {
        if(count > answer) return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx == R - 1 && ny == C - 1) {
                answer = Math.min(answer, count + 1);
            }
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] != 1) continue;
            dfs(map, nx, ny, count + 1);
        }
    }

    private void bfs(int[][] map, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if(nx == R - 1 && ny == C - 1) {
                    answer = Math.min(answer, cur[2] + 1);
                }
                if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != 1) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
    }
}
