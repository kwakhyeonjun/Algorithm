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

    private static Fish[][] fish;
    private static int[][] loc;
    private static Fish shark;
    private static int[] sharkLoc = {0, 0};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 물고기 위치 저장
        fish = new Fish[4][4];
        shark = new Fish(0, fish[0][0].fishDir);
        loc = new int[17][2];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                fish[i][j] = new Fish(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                loc[fish[i][j].num] = new int[]{i, j};
            }
        }

        do{
            moveFish();
        }while(moveShark());

        System.out.println(answer);
        br.close();
    }

    private static boolean moveShark(){
        int x = sharkLoc[0];
        int y = sharkLoc[1];
        int max = 0;

        while(true){
            int nx = x + dir[shark.fishDir][0];
            int ny = y + dir[shark.fishDir][1];

            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) break;

            max = Math.max(fish[nx][ny].num, max);
        }
        if(max == 0) return false;

        fish[loc[max][0]][loc[max][1]] = null;
        answer += max;
        return true;
    }

    private static void moveFish(){
        for (int i = 1; i < 17; i++) {
            int[] cur = loc[i];
            Fish curFish = fish[cur[0]][cur[1]];
            Fish nextFish = fish[cur[0] + dir[curFish.fishDir][0]][cur[1] + dir[curFish.fishDir][1]];
            if(nextFish.num == 0) continue;
            swap(cur, new int[]{cur[0] + dir[curFish.fishDir][0], cur[1] + dir[curFish.fishDir][1]});
        }
    }

    private static void swap(int[] cur, int[] next){
        Fish temp = fish[cur[0]][cur[1]];
        fish[cur[0]][cur[1]] = fish[next[0]][next[1]];
        fish[cur[0]][cur[1]] = temp;
    }
}
