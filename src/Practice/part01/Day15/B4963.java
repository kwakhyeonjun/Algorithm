package Practice.part01.Day15;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4963 {
    private static int w, h; // w, h 위치 조심
    private static boolean[][] map;
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;
            map = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    if(st.nextToken().equals("1")) map[i][j] = true;
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y){
        map[x][y] = false;
        for(int i = 0; i < 8; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(isInMap(nx, ny) && map[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        map[x][y] = false;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i = 0; i < 8; i++){
                int nx = current[0] + dir[i][0];
                int ny = current[1] + dir[i][1];
                if(isInMap(nx, ny) && map[nx][ny]){
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isInMap(int x, int y){
        return (x >= 0 && x < h && y >= 0 && y < w);
    }
}
