package Programmers.Level2;

import java.util.ArrayList;

public class Cycle {
    public static void main(String[] args) {
        Cycle sol = new Cycle();

    }

    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();
        visited = new boolean[grid.length][grid[0].length()][4]; // 아래 왼 위 오른
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                for (int d = 0; d < 4; d++) {
                    if(!visited[i][j][d]) answer.add(light(grid, i, j, d));
                }
            }
        }
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int R, C;
    private int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][][] visited;

    private int light(String[] grid, int r, int c, int d) {
        int count = 0;

        while(true) {
            if(visited[r][c][d]) break;

            count++;
            visited[r][c][d] = true;

            if(grid[r].charAt(c) == 'L'){
                d = d == 0 ? 3 : d - 1;
            }else if(grid[r].charAt(c) == 'R'){
                d = d == 3 ? 0 : d + 1;
            }

            r = (r + dir[d][0] + R) % R;
            c = (c + dir[d][1] + C) % C;
        }
        return count;
    }
}
