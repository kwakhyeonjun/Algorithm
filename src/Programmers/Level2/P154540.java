package Programmers.Level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P154540 {

    public static void main(String[] args) {
        P154540 sol = new P154540();

        int[] solution = sol.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
        for(int i : solution) System.out.println(i);
    }

    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[][] map;
    private boolean[][] visited;
    private int n, m;

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();

        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'X') continue;
                if(visited[i][j]) continue;

                day = map[i][j] - '0';
                visited[i][j] = true;
                dfs(i, j);

                list.add(day);
            }
        }

        if(list.size() == 0) return new int[]{-1};
        list.sort(Comparator.naturalOrder());

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private int day;

    private void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(isOutRange(nx, ny)) continue;
            if(map[nx][ny] == 'X') continue;
            if(visited[nx][ny]) continue;

            day += map[nx][ny] - '0';
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }

    private boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
