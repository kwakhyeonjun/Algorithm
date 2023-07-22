package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA5684 {

    private static final int MAX_N = 400;
    private static final int MAX_DIST = 1000 * MAX_N;
    private static int n, m, answer;
    private static int[][] map = new int[MAX_N][MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = MAX_DIST;
                }
            }

            for(int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                int s = Integer.parseInt(input[0]) - 1;
                int e = Integer.parseInt(input[1]) - 1;
                int c = Integer.parseInt(input[2]);

                map[s][e] = c;
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                answer = Math.min(answer, map[i][i]);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
