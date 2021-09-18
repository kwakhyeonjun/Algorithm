package Practice.part01.Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026 {
    private static int N;
    private static char[][] map;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                GR(i, j, false);
                count++;
            }
        }
        System.out.print(count + " ");
        count = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                GR(i, j, true);
                count++;
            }
        }
        System.out.println(count);
    }

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static void GR(int x, int y, boolean isGR){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        char current = map[x][y];
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            visited[loc[0]][loc[1]] = true;
            for(int i = 0; i < 4; i++){
                int nx = loc[0] + dir[i][0];
                int ny = loc[1] + dir[i][1];
                if(isInMap(nx, ny) && !visited[nx][ny] && current == map[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
                if(isGR && isInMap(nx, ny) && !visited[nx][ny]
                        && (current == map[nx][ny]
                        || current == 'G' && map[nx][ny] == 'R'
                        || current == 'R' && map[nx][ny] == 'G')){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isInMap(int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
