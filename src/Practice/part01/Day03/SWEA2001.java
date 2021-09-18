package Practice.part01.Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] flys = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    flys[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            int sum = 0;
            for(int i = 0; i <= N - M; i++){
                for(int j = 0; j <= N - M; j++){

                    for(int x = 0; x < M; x++){
                        for(int y = 0; y < M; y++){
                            sum += flys[i+x][j+y];
                        }
                    }
                    max = Math.max(sum, max);
                    sum = 0;
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}
