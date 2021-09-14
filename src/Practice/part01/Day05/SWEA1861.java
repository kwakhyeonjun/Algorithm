package Practice.part01.Day05;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1861 {
    private static int[][] map;
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(test_case).append(" ");

            int max = Integer.MIN_VALUE;
            int idx = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int count = move(i, j);
                    if(count > max){
                        idx = map[i][j];
                        max = count;
                    }
                    if(count == max && idx > map[i][j]){
                        idx = map[i][j];
                    }
                }
            }
            sb.append(idx).append(" ").append(max + 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int move(int x, int y){
        int[] result = new int[4];
        for(int i = 0; i < 4; i++){
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != map[x][y]+1) continue;
            result[i] = 1 + move(nx, ny, i);
        }
        int max = 0;
        for(int i = 0; i < 4; i++){
            max = Math.max(max, result[i]);
        }
        return max;
    }

    private static int move(int x, int y, int dir){
        int[] result = new int[4];
        int setDir = ( dir%2==0 ? dir + 1 : dir - 1 );
        for(int i = 0; i < 4; i++){
            if(i != setDir){
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != map[x][y]+1) continue;
                result[i] = 1 + move(nx, ny, i);
            }
        }
        int max = 0;
        for(int i = 0; i < 4; i++){
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
