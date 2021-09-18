package Practice.part01.Day10;

import java.io.*;
import java.util.StringTokenizer;

public class B15686 {
    private static int N, M, min = Integer.MAX_VALUE;
    private static int[][] map;
    private static int[][] result;
    private static int[][] chicken;
    private static int[][] home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        int chickenIdx = 0;
        int chickenCount = 0;
        int homeIdx = 0;
        int homeCount = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    chickenCount++;
                }else if(map[i][j] == 1){
                    homeCount++;
                }
            }
        }

        chicken = new int[chickenCount][2];
        home = new int[homeCount][2];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 2) {
                    chicken[chickenIdx][0] = i;
                    chicken[chickenIdx++][1] = j;
                }else if(map[i][j] == 1){
                    home[homeIdx][0] = i;
                    home[homeIdx++][1] = j;
                }
            }
        }

        for(int i = 1; i <= M; i++){
            result = new int[i][2];
            comb(0, 0, i);
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void comb(int count, int start, int r){
        if(count == r){
            int sum = 0; // 각 집에서의 치킨거리 합
            for(int i = 0; i < home.length; i++){
                int x1 = home[i][0];
                int y1 = home[i][1];
                int minDistance = Integer.MAX_VALUE; // i번째 집에서의 치킨거리
                for(int j = 0; j < result.length; j++){
                    int x2 = result[j][0];
                    int y2 = result[j][1];
                    int distance = getDistance(x1, y1, x2, y2);
                    minDistance = Math.min(minDistance, distance);
                }
                sum += minDistance;
            }
            min = Math.min(min, sum);
            return;
        }else{
            for(int i = start; i < chicken.length; i++){
                result[count] = chicken[i];
                comb(count+1, i + 1, r);
            }
        }
    }

    private static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
