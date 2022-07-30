package Programmers.Curriculum;

import java.util.*;

public class P72415 {
    public static void main(String[] args) {
        P72415 sol = new P72415();
        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;
        System.out.println(sol.solution(board, r, c));
    }

    public int solution(int[][] board, int r, int c) {
        this.r = r;
        this.c = c;
        this.board = board;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] == 0) continue;
                set.add(board[i][j]);
            }
        }

        int[] cards = new int[set.size()];
        int idx = 0;
        for(int s : set) {
            cards[idx++] = s;
        }

        int n = cards.length;
        picked = new int[n];
        pickVisited = new boolean[n];
        min = Integer.MAX_VALUE;

        orderCardsPick(cards, 0);

        return min;
    }

    private int[][] board;
    private int[] picked;
    private boolean[] pickVisited;

    private int r, c, min, x, y;

    private void orderCardsPick(int[] cards, int count) {
        if(count == cards.length) {
            int sum = 0;
            this.x = this.r;
            this.y = this.c;
            int[][] board = new int[4][4];
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    board[i][j] = this.board[i][j];
                }
            }
            for (int card : picked) {
                sum += bfs(board, card);
                sum += bfs(board, card);
            }
            System.out.println(Arrays.toString(picked) + ": " + sum);
            min = Math.min(min, sum);
        } else {
            for(int i = 0; i < cards.length; i++) {
                if(pickVisited[i]) continue;
                pickVisited[i] = true;
                picked[count] = cards[i];
                orderCardsPick(cards, count + 1);
                pickVisited[i] = false;
            }
        }
    }

    private final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int bfs(int[][] board, int card) {
        if(board[this.x][this.y] == card) {
            board[this.x][this.y] = 0;
            return 1;
        }
        boolean[][] bfsVisited = new boolean[4][4];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{this.x, this.y, 0});
        bfsVisited[this.x][this.y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
                if(bfsVisited[nx][ny]) continue;
                if(board[nx][ny] == card) {
                    this.x = nx;
                    this.y = ny;
                    board[this.x][this.y] = 0;
                    return cur[2] + 2;
                }
                bfsVisited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, cur[2] + 1});
            }
            for(int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                    if(board[nx][ny] != 0) break;
                    nx += dir[i][0];
                    ny += dir[i][1];
                }
                if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
                if(bfsVisited[nx][ny]) continue;
                if(board[nx][ny] == card) {
                    this.x = nx;
                    this.y = ny;
                    board[this.x][this.y] = 0;
                    return cur[2] + 2;
                }
                bfsVisited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, cur[2] + 1});

            }
        }
        return -1;
    }
}
