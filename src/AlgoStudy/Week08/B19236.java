package AlgoStudy.Week08;

import java.io.*;
import java.util.StringTokenizer;

public class B19236 {

    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    private static int[][] dir = {{}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    private static class Fish {
        int num;
        int fishDir;

        Fish(int num, int fishDir){
            this.num = num;
            this.fishDir = fishDir;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 물고기 위치 저장
        Fish[][] fish = new Fish[4][4];
        Fish shark = new Fish(0, fish[0][0].fishDir);
        int[][] loc = new int[17][2];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                fish[i][j] = new Fish(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                loc[fish[i][j].num] = new int[]{i, j};
            }
        }





    }
}
