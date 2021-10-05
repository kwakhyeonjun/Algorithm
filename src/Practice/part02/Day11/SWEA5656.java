package Practice.part02.Day11;

import java.io.*;
import java.util.*;

public class SWEA5656 {

    private static int N, W, H, answer;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            selected = new int[N];
            visited = new boolean[H][W];
            setBalls(0);

            bw.write("#" + test_case + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] selected;

    private static void setBalls(int count){
        if(count == N){
            int[][] tempMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    tempMap[i][j] = map[i][j];
                }
            }
            dropBalls(tempMap);
        }else{
            for (int i = 0; i < W; i++) {
                selected[count] = i;
                setBalls(count + 1);
            }
        }
    }

    private static void dropBalls(int[][] curMap){
        for (int i = 0; i < N; i++) {
            int cur = selected[i];
            int topBlock = -1;
            for (int j = 0; j < H; j++) {
                if(curMap[j][cur] != 0){
                    topBlock = j;
                    break;
                }
            }
            if(topBlock == -1) continue;
            boom(curMap, topBlock, cur);

            curMap = setBlocks(curMap);
        }

        int countBlock = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(curMap[i][j] > 0) countBlock++;
            }
        }
        answer = Math.min(answer, countBlock);
    }

    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
    private static boolean[][] visited;


    private static void boom(int[][] curMap, int x, int y){
        int power = curMap[x][y];

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int p = 1; p < power; p++) {
                int nx = x + dir[i][0] * p;
                int ny = y + dir[i][1] * p;

                if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] > 0) {
                    list.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        curMap[x][y] = 0;
        for (int[] pos : list) {
            boom(curMap, pos[0], pos[1]);
            curMap[pos[0]][pos[1]] = 0;
        }
    }

    private static int[][] setBlocks(int[][] curMap){
        Stack<Integer> stack = new Stack<>();
        int[][] tempMap = new int[H][W];
        for (int j = 0; j < W; j++) {
            for (int i = 0; i < H; i++) {
                if(curMap[i][j] > 0) stack.add(curMap[i][j]);
            }

            for (int i = H - 1; i >= 0; i--) {
                if(stack.isEmpty()) break;
                tempMap[i][j] = stack.pop();
            }
        }
        return tempMap;
    }
}
