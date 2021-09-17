package Practice.part02.Day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1767 {

    private static class Core {
        int x;
        int y;

        Core(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static boolean[][] map;
    private static List<Core> cores;

    /**
     * 1. 노드 찾기
     * 2. 노드에서 연결 가능한 곳 찾기
     * 3. 최대한 많은 코어에 연결했을 때, 전선의 길이가 최소가 되는 값을 구함.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){

            // map setting
            N = Integer.parseInt(br.readLine());
            map = new boolean[N][N];
            cores = new ArrayList<>();
            coreAll = 0;
            maxCoreCont = 0;
            minLineCount = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken().equals("1");
                    if(map[i][j]) {
                        coreAll++;
                        if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
                        cores.add(new Core(i, j));
                    }
                }
            }

            comb(0, 0);
            System.out.println("#" + test_case + " " + (minLineCount == Integer.MAX_VALUE ? 0 : minLineCount));
        }
    }

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int coreCount, lineCount, maxCoreCont, minLineCount, coreAll;

    private static void comb(int count, int start){

        if(coreCount >= maxCoreCont) {
            if (coreCount > maxCoreCont) minLineCount = Integer.MAX_VALUE;
            maxCoreCont = coreCount;
            lineCount = getLineCount(map);
            if (lineCount < minLineCount) minLineCount = Math.min(lineCount, minLineCount);
        }

        for (int i = start; i < cores.size(); i++) {
            for (int j = 0; j < 4; j++) {
                int nx = cores.get(i).x;
                int ny = cores.get(i).y;
                List<int[]> lines = new ArrayList<>();
                while(true){
                    nx += dir[j][0];
                    ny += dir[j][1];
                    if(!isInMap(nx, ny)) {
                        coreCount++;
                        for (int k = 0; k < lines.size(); k++) {
                            int[] cur = lines.get(k);
                            map[cur[0]][cur[1]] = true;
                        }
                        comb(count + 1, i + 1);
                        for (int k = 0; k < lines.size(); k++) {
                            int[] cur = lines.get(k);
                            map[cur[0]][cur[1]] = false;
                        }
                        coreCount--;
                        break;
                    }
                    if(map[nx][ny]) break;
                    lines.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static int getLineCount(boolean[][] map){
        int lineCount = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j]) lineCount++;
            }
        }
        return lineCount - coreAll;
    }

    private static boolean isInMap(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}