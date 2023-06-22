package Programmers.ret;

import java.util.*;

public class P1836 {
    public static void main(String[] args) {
        P1836 sol = new P1836();
        String answer = sol.solution(4, 4, new String[]{"A..C", "..CB", "B...", "...A"});
        System.out.println(answer);
    }

    public String solution(int m, int n, String[] board) {
        String answer = "";

        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<Character, int[]> map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cur = board[i].charAt(j);
                if(cur < 'A' || cur > 'Z') continue;
                if(!map.containsKey(cur)) {
                    list.add(cur);
                    map.put(cur, new int[]{i, j});
                }
            }
        }

        list.sort(Comparator.naturalOrder());

        boolean flag = true;

        while(flag) {
//            System.out.print("list = {");
//            for (Character c : list) {
//                System.out.print(c + ",");
//            }
//            System.out.println("}");

            flag = false;
            if(list.isEmpty()) break;
            for (Character c : list) {
                int[] cur = map.get(c);
                if(bfs(board, m, n, cur)) {
//                    System.out.println("remove = " + c);
                    sb.append(c);
                    list.remove(c);
                    flag = true;
                    break;
                }
            }
        }

        if(list.size() != 0) return "IMPOSSIBLE";
        return sb.toString();
    }

    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean bfs(String[] board, int m, int n, int[] prev) {
        Queue<int[]> queue = new LinkedList<>();
        // x, y, d, turnCount
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{prev[0], prev[1], 0, 0});
        visited[prev[0]][prev[1]] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[3] > 1) {
                int nx = cur[0] + dir[cur[2]][0];
                int ny = cur[1] + dir[cur[2]][1];

                if(isOutRange(m, n, nx, ny)) continue;
//                if(visited[nx][ny]) continue;
                if(nx == prev[0] && ny == prev[1]) continue;

                if(board[nx].charAt(ny) == board[prev[0]].charAt(prev[1])) {
                    change(board, nx, ny);
                    change(board, prev[0], prev[1]);
                    return true;
                }

                char curAlp = board[nx].charAt(ny);
                if((curAlp >= 'A' && curAlp <= 'Z') || curAlp == '*') continue;

                queue.add(new int[]{nx, ny, cur[2], cur[3]});
                visited[nx][ny] = true;
            } else {
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dir[i][0];
                    int ny = cur[1] + dir[i][1];

                    if(isOutRange(m, n, nx, ny)) continue;
//                    if(visited[nx][ny]) continue;
                    if(nx == prev[0] && ny == prev[1]) continue;

                    if(board[nx].charAt(ny) == board[prev[0]].charAt(prev[1])) {
                        change(board, nx, ny);
                        change(board, prev[0], prev[1]);
                        return true;
                    }

                    char curAlp = board[nx].charAt(ny);
                    if((curAlp >= 'A' && curAlp <= 'Z') || curAlp == '*') continue;

                    if(cur[3] > 0 && cur[2] == i) queue.add(new int[]{nx, ny, i, cur[3]});
                    else queue.add(new int[]{nx, ny, i, cur[3] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }

    private void change(String[] board, int x, int y) {
        StringBuilder sb = new StringBuilder(board[x]);
        sb.setCharAt(y, '.');
        board[x] = sb.toString();
    }
    private boolean isOutRange(int m, int n, int x, int y) {
        return x < 0 || x >= m || y < 0 || y >= n;
    }
}
