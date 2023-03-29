package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Candy {

    private static int n, m;
    private static int[] red = new int[2];
    private static int[] blue = new int[2];
    private static int[] out = new int[2];
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        init(br);

        dfs();
        System.out.println(answer);
    }

    private static int answer;

    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void dfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(red, blue, 0));
        Set<Candies> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            int[] red = new int[]{cur.red[0], cur.red[1]};
            int[] blue = new int[]{cur.blue[0], cur.blue[1]};

//            System.out.println("<<SET>>");
//            System.out.println("red = " + red[0] + ", " + red[1]);
//            System.out.println("blue = " + blue[0] + ", " + blue[1]);
//            System.out.println();

            set.add(new Candies(red[0], red[1], blue[0], blue[1]));

            for (int[] d : dir) {
                moveSet(red, blue, d);

                if(set.contains(new Candies(red[0], red[1], blue[0], blue[1]))) continue;
                if(isOut(blue)) continue;
                if(isOut(red)) {
                    answer = cur.count;
                    return;
                }
                if(Arrays.equals(blue, cur.blue) && Arrays.equals(red, cur.red)) continue;

                System.out.println("<<Queue>>");
                System.out.println("count = " + cur.count);
                System.out.println("red = " + red[0] + ", " + red[1]);
                System.out.println("blue = " + blue[0] + ", " + blue[1]);
                System.out.println();

                queue.add(new Pos(red, blue, cur.count + 1));

            }
        }
    }

    private static boolean isOut(int[] candy) {
        return candy[0] == out[0] && candy[1] == out[1];
    }

    private static void moveSet(int[] red, int[] blue, int[] d) {
        move(d, red);
        move(d, blue);
    }

    private static void move(int[] d, int[] candy) {
        while(true) {
            int nx = candy[0] + d[0];
            int ny = candy[1] + d[1];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
            if("#".equals(map[nx][ny])) break;

            candy[0] = nx;
            candy[1] = ny;

            if(nx == out[0] && ny == out[1]) break;
        }
    }

    private static void init(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            map[i] = input;
            for (int j = 0; j < m; j++) {
                if("B".equals(map[i][j])) {
                    blue = new int[]{i, j};
                    map[i][j] = ".";
                }
                if("R".equals(map[i][j])) {
                    red = new int[]{i, j};
                    map[i][j] = ".";
                }
                if("O".equals(map[i][j])) {
                    out = new int[]{i, j};
                    map[i][j] = ".";
                }
            }
        }
    }

    static class Pos {
        int[] red;
        int[] blue;
        int count;

        public Pos(int[] red, int[] blue, int count) {
            this.red = new int[]{red[0], red[1]};
            this.blue = new int[]{blue[0], blue[1]};
            this.count = count;
        }
    }

    static class Candies {
        int rnx;
        int rny;
        int bnx;
        int bny;

        public Candies(int rnx, int rny, int bnx, int bny) {
            this.rnx = rnx;
            this.rny = rny;
            this.bnx = bnx;
            this.bny = bny;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Candies candies = (Candies) o;
            return rnx == candies.rnx && rny == candies.rny && bnx == candies.bnx && bny == candies.bny;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rnx, rny, bnx, bny);
        }
    }
}
