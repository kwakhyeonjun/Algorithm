package IM;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1961 {
    private static int[][] map;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rot90 = rotate(map);
            int[][] rot180 = rotate(rot90);
            int[][] rot270 = rotate(rot180);

            bw.write("#" + test_case + "\n");
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    bw.write(String.valueOf(rot90[i][j]));
                }
                bw.write(" ");
                for(int j = 0; j < N; j++){
                    bw.write(String.valueOf(rot180[i][j]));
                }
                bw.write(" ");
                for(int j = 0; j < N; j++){
                    bw.write(String.valueOf(rot270[i][j]));
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[][] rotate(int[][] map){
        int[][] newMap = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                newMap[i][j] = map[N-j-1][i];
            }
        }
        return newMap;
    }
}
