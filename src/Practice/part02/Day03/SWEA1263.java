package Practice.part02.Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[][] dist = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    dist[i][j] = Integer.parseInt(st.nextToken());
                    if(dist[i][j] == 0) dist[i][j] = 10000;
                    if(i == j) dist[i][j] = 0;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }

            int[] connectCount = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    connectCount[i] += dist[i][j];
                }
            }

            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                answer = Math.min(answer, connectCount[i]);
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
