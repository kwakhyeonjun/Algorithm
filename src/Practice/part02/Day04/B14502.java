package Practice.part02.Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502 {

    private static int N, M, C, safeCount, maxSafeCount;
    private static int[][] map;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        C = N * M;
        comb();
        System.out.println(maxSafeCount);
    }

    private static void comb() {
        for(int i = 0; i < C; i++){
            for(int j = i + 1; j < C; j++){
                for (int k = j + 1; k < C; k++) {
                    int x1 = i/M; int y1 = i%M;
                    int x2 = j/M; int y2 = j%M;
                    int x3 = k/M; int y3 = k%M;

                    if(map[x1][y1] != 0 || map[x2][y2] != 0 || map[x3][y3] != 0) continue;

                    map[x1][y1] = 1;
                    map[x2][y2] = 1;
                    map[x3][y3] = 1;

                    safeCount = 0;
                    bfs();
                    maxSafeCount = Math.max(maxSafeCount, safeCount);

                    map[x1][y1] = 0;
                    map[x2][y2] = 0;
                    map[x3][y3] = 0;
                }
            }
        }
    }

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        int[][] curMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                curMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(curMap[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(curMap[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    curMap[nx][ny] = 2;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if(curMap[i][j] == 0) safeCount++;
            }
        }
    }
}