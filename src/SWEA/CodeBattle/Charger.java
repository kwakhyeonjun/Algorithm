package SWEA.CodeBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Charger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());

            List<House> houseList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                houseList.add(new House(15 + Integer.parseInt(input[0]), 15 + Integer.parseInt(input[1]), Integer.parseInt(input[2])));
            }

            map = new Point[31][31];

            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 31; j++) {
                    map[i][j] = new Point();
                }
            }

            for (House house : houseList) {
                setDir(house.x, house.y, house.dist);
            }

            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 31; j++) {

                }
            }
        }
    }

    private static void iterMap() {
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {

            }
        }
    }

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static Point[][] map;

    private static void setDir(int x, int y, int dist) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, dist});
        boolean[][] visited = new boolean[31][31];
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cDir = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];

                if(nx < 0 || nx > 30 || ny < 0 || ny > 30) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                map[nx][ny].val += cDir;

                if(cDir - 1 == 0) continue;
                queue.add(new int[]{nx, ny, cDir -1});
            }
        }
    }

    private static class Point {
        int val;
        List<Integer> houses;

        Point() {
            this.val = 0;
            this.houses = new ArrayList<>();
        }
    }

    private static class House {
        int x;
        int y;
        int dist;

        public House(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
