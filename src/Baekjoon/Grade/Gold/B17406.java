package Baekjoon.Grade.Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17406 {

    private static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] rot = new int[k][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            rot[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rot[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rot[i][2] = Integer.parseInt(st.nextToken());
        }

        permutation(arr, rot, new int[k][3], new boolean[k], 0, k, k);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void rotate(int[][] arr, int r, int c, int s){
        int startX = r - s;
        int startY = c - s;
        int distance = 2*s;

        int x = startX;
        int y = startY;
        int dir = 0;
        while(true){
            if(x + direction[dir][0] == startX && y + direction[dir][1] == startY){
                x += direction[dir][0] + 1;
                y += direction[dir][1] + 1;
                startX = x;
                startY = y;
                distance -= 2;
                dir = 0;

                if(x == r && y == c) break;
            }
            if(!isInArray(arr, x + direction[dir][0], y + direction[dir][1], startX, startY, distance)){
                dir = (dir + 1)%4;
            }
            int nx = x + direction[dir][0];
            int ny = y + direction[dir][1];
            swap(arr, x, y, nx, ny);
            x = nx;
            y = ny;
        }
    }

    private static boolean isInArray(int[][] arr, int x, int y, int disX, int disY, int distance){
        if(x < disX || x > disX + distance || y < disY || y > disY + distance) return false;
        else return true;
    }

    private static void swap(int[][] arr, int x1, int y1, int x2, int y2){
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static void permutation(int[][] arr, int[][] rot, int[][] output, boolean[] visited, int depth, int n, int r){
        if(depth == r){
            int[][] temp = new int[arr.length][arr[0].length];
            for(int i = 0; i < arr.length; i++){
                temp[i] = Arrays.copyOf(arr[i], arr[0].length);
            }
            for(int i = 0; i < output.length; i++){
                rotate(temp, output[i][0], output[i][1], output[i][2]);
            }
            getMin(temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = rot[i];
                permutation(arr, rot, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    private static void getMin(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = 0; j < arr[0].length; j++){
                sum += arr[i][j];
            }
            min = Math.min(sum, min);
        }
    }
}
