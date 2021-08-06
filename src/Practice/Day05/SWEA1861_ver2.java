package Practice.Day05;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1861_ver2 {
    private static int[][] map;
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(test_case).append(" ");

            int[] isNear = new int[N*N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < 4; k++){
                        int nx = i + direction[k][0];
                        int ny = j + direction[k][1];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(map[nx][ny] == map[i][j] + 1){
                            isNear[map[i][j]]++;
                        }
                    }
                }
            }

            int count = 0;
            int max = 0;
            int idx = 0;
            for(int i = N*N-1; i > 0; i--){
                if(isNear[i] == 1 && isNear[i-1] == 1) count++;
                else if(isNear[i] == 1 && isNear[i-1] == 0){
                    count++;
                    if(max == count) idx = i;
                    if(max < count){
                        idx = i;
                        max = count;
                        count = 0;
                    }
                    count = 0;
                }
            }

            sb.append(idx).append(" ").append(max+1).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
