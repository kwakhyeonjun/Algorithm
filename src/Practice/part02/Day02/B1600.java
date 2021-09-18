package Practice.part02.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {

    private static class Pos{
        int x;
        int y;
        int k;
        int count;

        Pos(int x, int y, int k, int count){
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }
    }

    private static int W, H;
    private static boolean[][] map;
    private static boolean[][][] visited;
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = st.nextToken().equals("0");
            }
        }

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, K, 0));
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            for(int i = 0; i < 12; i++){
                if(cur.k <= 0 && i > 4) continue;
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if(nx == H - 1 && ny == W - 1){
                    System.out.println(cur.count);
                    return;
                }
                if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if(!map[nx][ny]) continue;
                if(visited[nx][ny][cur.k]) continue;
                visited[nx][ny][cur.k] = true;
                queue.add(new Pos(nx, ny, i > 4 ? cur.k - 1 : cur.k, cur.count + 1));
            }
        }

        System.out.println(-1);
    }
}