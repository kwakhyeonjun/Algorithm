package Practice.part01.Day13;

import java.io.*;
import java.util.StringTokenizer;

public class B1987 {
    private static int R, C, count, max;
    private static char[][] map;
    private static boolean[] alphabet;
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }
        alphabet = new boolean[26];
        dfs(0, 0, alphabet, 1);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, boolean[] alphabet, int count){
        alphabet[map[x][y] - 'A'] = true;
        boolean isFind = false;
        for(int d = 0; d < 4; d++){
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if(isInMap(nx, ny) && !isCheckAlphabet(alphabet, nx, ny)){
                dfs(nx, ny, copyArray(alphabet), count+1);
                isFind = true;
            }
        }
        if(!isFind){
            max = Math.max(max, count);
        }
    }

    private static boolean[] copyArray(boolean[] arr){
        boolean[] newArr = new boolean[26];
        for(int i = 0; i < 26; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private static boolean isCheckAlphabet(boolean[] alphabet, int x, int y) {
        return alphabet[map[x][y] - 'A'];
    }

    private static boolean isInMap(int x, int y){
        return (x >= 0 && x < R && y >= 0 && y < C);
    }
}
