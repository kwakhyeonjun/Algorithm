package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SE201802PM02 {

    private static final int MAX_N = 20;
    private static final int[][] step = new int[MAX_N][MAX_N];
    private static final int[][] map = new int[MAX_N][MAX_N];
    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static final Queue<int[]> queue = new LinkedList<>();
    private static final boolean[][] visited = new boolean[MAX_N][MAX_N];

    private static int x, y, level = 2, killCount = 0;
    private static int px, py, dl;
    private static int n, answer;

    private static void delete() {
        answer += step[px][py];
        map[px][py] = 0;
        x = px;
        y = py;
        killCount++;
        if(killCount == level) {
            killCount = 0;
            level++;
        }
    }

    private static boolean find() {
        int min = MAX_N * MAX_N;
        boolean isFind = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0) continue;
                if(step[i][j] == 0) continue;
                if(map[i][j] >= level) continue;

                if(min > step[i][j]) {
                    px = i;
                    py = j;
                    min = step[px][py];
                    isFind = true;
                }
            }
        }

        return isFind;
    }

    private static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    private static void initVisited() {
        queue.clear();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
                step[i][j] = 0;
            }
        }
    }

    private static void bfs() {
        initVisited();

        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int[] d : dir) {
                int nx = cx + d[0];
                int ny = cy + d[1];

                if(isOutRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] > level) continue;

                step[nx][ny] = step[cx][cy] + 1;

                queue.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] input;
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                int lv = Integer.parseInt(input[j]);
                if(lv == 9) {
                    x = i;
                    y = j;
                }
                else map[i][j] = lv;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        while(find()) {
//			System.out.println("step: ");
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(step[i][j] + " ");
//				}
//				System.out.println();
//			}
            delete();
            bfs();
        }
        System.out.println(answer);
    }
}
