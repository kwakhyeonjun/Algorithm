package Practice.part01.Day14;

import java.io.*;
import java.util.*;

public class B15683 {

    private static int N, M, nx, ny;
    private static int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 우, 하, 좌, 상
    private static int[][] rotate = {{}, {0}, {0, 1}, {0, 2}, {0, 1, 2, 3}};
    private static int[][] map;
    private static int[] trun = {-1, -1};
    private static Queue<int[]> CCTVs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) CCTVs.add(new int[]{i, j});
            }
        }
    }

    private static void dfs(){
        if(CCTVs.isEmpty()) return;
        int[] CCTV = CCTVs.poll();
        int x = CCTV[0];
        int y = CCTV[1];
        getNewLoc(x, y, map[x][y]);
        while(true){

        }
    }

    private static void getNewLoc(int x, int y, int type){

    }

    private static boolean isInMap(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}
