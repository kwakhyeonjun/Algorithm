package Practice.Day13;

import java.io.*;
import java.util.StringTokenizer;

public class B3109 {
    private static int[] dir = {-1, 0, 1};
    private static char[][] map;
    private static int R, C, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i = 0; i < R; i++){
            String input = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            dfs(i, 0);
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean dfs(int x, int y){
        for(int i = 0; i < 3; i++){
            int nx = x + dir[i];
            int ny = y + 1;

            if(nx >= 0 && nx < R && map[nx][ny] == '.'){
                if(ny == C - 1){
                    count++;
                    return true;
                }
                map[nx][ny] = 'X';
                if(dfs(nx, ny)) return true;
            }
        }
        return false;
    }
}
