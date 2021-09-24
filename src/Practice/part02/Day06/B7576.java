package Practice.part02.Day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) queue.add(new int[]{i, j, 0});
            }
        }

        int answer = -1;

        // bfs
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            answer = cur[2];
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny, cur[2] + 1});
                    map[nx][ny] = 1;
                }
            }
        }

        if(isAll(map)) System.out.println(answer);
        else System.out.println(-1);

    }

    private static boolean isAll(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
