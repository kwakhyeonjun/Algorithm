package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7236 {
    private static int N;
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 'W') {
                        max = Math.max(max, getWater(i, j));
                    }
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    private static int[][] dir = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    private static int getWater(int x, int y){
        int count = 0;
        for(int i = 0; i < 8; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(map[nx][ny] == 'W') count++;
            }
        }
        if(count == 0) return 1;
        else return count;
    }
}
