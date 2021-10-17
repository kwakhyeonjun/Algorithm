package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Core{
    int x;
    int y;

    int[] dir = new int[4]; // 상, 하, 좌, 우

    public Core(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class SWEA1767 {
    private static int min, maxCore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // test case
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){

            // input processing
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Core setting - 맵 가장자리는 제외하고, 각 코어의 위치를 저장
            List<Core> cores = new ArrayList<>();
            min = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 1 && i != 0 && i != N-1 && j != 0 && j != N-1){ // map에서 core를 찾은 경우, 바깥의 코어가 아닌 경우에
                        cores.add(new Core(i, j));
                    }
                }
            }
            // 코어에서 줄 연결하기
            chooseLine(map, cores, 0, 0, 0, 0);

            bw.write(String.valueOf(min));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void chooseLine(int[][] map, List<Core> cores, int start, int count, int sum, int countCore){
        int N = map.length;
        if(count == cores.size()){
            min = Math.min(min, sum);
            return;
        }
        for(int i = start; i < cores.size(); i++){
            Core currentCore = cores.get(i);
            setDir(map, currentCore);
            for(int j = 0; j < 4; j++){
                if(currentCore.dir[j] != -1){
                    int[][] tempMap = getTempMap(map);
                    drawLine(tempMap, currentCore, j);
                    chooseLine(tempMap, cores, start + 1, count + 1, sum + currentCore.dir[j], countCore + 1);
                }
            }
        }
    }

    private static void drawLine(int[][] map, Core core, int dir) {
        int N = map.length;
        int x = core.x;
        int y = core.y;
        for(int i = 0; i < N; i++){
            switch (dir){
                case 0:
                    if(i < x) map[i][y] = 1;
                    break;
                case 1:
                    if(i > x) map[i][y] = 1;
                    break;
                case 2:
                    if(i < y) map[x][i] = 1;
                    break;
                case 3:
                    if(i > y) map[x][i] = 1;
                    break;
            }
        }
    }

    private static int[][] getTempMap(int[][] map) {
        int N = map.length;
        int[][] tempMap = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tempMap[i][j] = map[i][j];
            }
        }
        return tempMap;
    }

    private static void setDir(int[][] map, Core core){
        int N = map.length;
        int x = core.x;
        int y = core.y;

        int[] dir = new int[4];
        dir[0] = x;
        dir[1] = N - x - 1;
        dir[2] = y;
        dir[3] = N - y - 1;

        for(int i = 0; i < N; i++){
            if(i < x && map[i][y] == 1) dir[0] = -1;
            if(i > x && map[i][y] == 1) dir[1] = -1;
            if(i < y && map[x][i] == 1) dir[2] = -1;
            if(i > y && map[x][i] == 1) dir[3] = -1;
        }

        core.dir = dir;
    }
}
