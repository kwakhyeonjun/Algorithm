package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class P169199 {
    public static void main(String[] args) {
        P169199 sol = new P169199();
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        int answer = sol.solution(board);
        System.out.println(answer);
    }

    public int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];

        setMap(board);

        return bfs();
    }

    private void setMap(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                switch (board[i].charAt(j)) {
                    case 'R':
                        cur = new int[]{i, j};
                        break;
                    case 'G':
                        goal = new int[]{i, j};
                        break;
                    default:
                        map[i][j] = board[i].charAt(j);
                        break;
                }
            }
        }
    }

    private char[][] map;
    private int[] cur;
    private int[] goal;
    private boolean[][] visited;
    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cur[0], cur[1], 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            visited[cx][cy] = true;

            for (int i = 0; i < 4; i++) {
                int[] next = move(cx, cy, i);

                if(visited[next[0]][next[1]]) continue;
                if(next[0] == goal[0] && next[1] == goal[1]) return cur[2] + 1;

                queue.add(new int[]{next[0], next[1], cur[2] + 1});
            }
        }
        return -1;
    }

    private int[] move(int x, int y, int d) {
        int cx = x;
        int cy = y;
        while(true) {
            int nx = cx + dir[d][0];
            int ny = cy + dir[d][1];

            if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) break;
            if(map[nx][ny] == 'D') break;

            cx = nx;
            cy = ny;
        }

        return new int[]{cx, cy};
    }
}
