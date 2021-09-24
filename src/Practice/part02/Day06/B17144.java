package Practice.part02.Day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17144 {

    private static int R, C, T;
    private static int[][] airCleaner;
    private static int[][] map;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        airCleaner = new int[2][2];
        int cleanerCount = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) airCleaner[cleanerCount++] = new int[]{i, j};
            }
        }

        visited = new boolean[R][C];

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] > 0) moveDust(i, j);
                }
            }
            moveAirCleaner();
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    private static int[][] airDir = {{3, 0, 2, 1}, {2, 0, 3, 1}};
    private static void moveAirCleaner(){
        for(int cleanerIdx = 0; cleanerIdx < 2; cleanerIdx++){
            int[] cur = airCleaner[cleanerIdx];
            int x = cur[0];
            int y = cur[1];
            int dirIdx = 0;
            while(true){
                int nx = x + dir[airDir[cleanerIdx][dirIdx]][0];
                int ny = y + dir[airDir[cleanerIdx][dirIdx]][1];
                if(!isInMap(nx, ny) || (nx == cur[0] && ny == C - 1)){
                    dirIdx++;
                    continue;
                }
                if(nx == cur[0] && ny == cur[1]) break;

                if(x == cur[0] && y == cur[1]) map[nx][ny] = 0;
                else map[x][y] = map[nx][ny];

                x = nx;
                y = ny;
            }
        }
    }

    private static boolean[][] visited;

    private static void moveDust(int x, int y){
        int diffusionCount = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(!isInMap(nx, ny)) continue;
            if(map[nx][ny] < 0) continue;
            map[nx][ny] += map[x][y]/5;
            diffusionCount++;
        }
        map[x][y] -= (map[x][y]/5) * diffusionCount;
    }

    private static boolean isInMap(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
