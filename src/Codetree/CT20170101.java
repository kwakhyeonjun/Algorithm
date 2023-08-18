package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CT20170101 {
    private static final int MAX_N = 202, MAX_M = 202;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.

        // set input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        // init map
        int[][][] map = new int[MAX_N][MAX_M][4];

        for(int i = 0; i < n; i++) {
            split = br.readLine().split(" ");

            for(int j = 0; j < m; j++) {
                int cur = Integer.parseInt(split[j]);
                map[i][j][0] = cur;
                map[j][n - 1 - i][1] = cur;
                map[n - 1 - i][m - 1 - j][2] = cur;
                map[m - 1 - j][i][3] = cur;
            }
        }

        // set Blocks
        int[][][] blocks = new int[7][4][2];

        blocks[0] = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        blocks[1] = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        blocks[2] = new int[][]{{0, 0}, {1, 0}, {2, 0}, {2, 1}};
        blocks[3] = new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 1}};
        blocks[4] = new int[][]{{0, 0}, {1, 0}, {2, 0}, {1, 1}};
        blocks[5] = new int[][]{{0, 1}, {1, 1}, {1, 0}, {2, 0}};
        blocks[6] = new int[][]{{0, 1}, {1, 1}, {2, 1}, {2, 0}};

        // iter all blocks in rot map (4*7*n*m*4)
        int answer = 0;
        // rotate map(4)
        for(int r = 0; r < 4; r++) {
            boolean isRot = r%2 == 0;

            // iter blocks(7)
            for(int b = 0; b < 7; b++) {
                // iter map(n*m)
                for(int i = 0; i < (isRot ? n : m); i++) {
                    for(int j = 0; j < (isRot ? m : n); j++) {
                        int sum = 0;

                        // iter block(4)
                        for(int k = 0; k < 4; k++) {
                            int nx = i + blocks[b][k][0];
                            int ny = j + blocks[b][k][1];

                            sum += map[nx][ny][r];
                        }

                        answer = Math.max(answer, sum);
                    }
                }
            }
        }

        // output
        System.out.println(answer);
    }
}