package IM;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1974 {
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            map = new int[9][9];
            for(int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j< 9; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 1;
            for(int i = 0; i < 9; i = i + 3){
                for(int j = 0; j < 9; j = j + 3){
                    if(!isBox(i, j)) {
                        result = 0;
                        break;
                    }
                }
            }

            for(int i = 0; i < 9; i++){
                nums = new boolean[9];
                for(int j = 0; j < 9; j++){
                    nums[map[i][j] - 1] = true;
                }
                if(!isAllNums()){
                    result = 0;
                    break;
                }
            }
            for(int i = 0; i < 9; i++){
                nums = new boolean[9];
                for(int j = 0; j < 9; j++){
                    nums[map[j][i] - 1] = true;
                }
                if(!isAllNums()){
                    result = 0;
                    break;
                }
            }

            bw.write("#" + test_case + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean[] nums;
    private static boolean isBox(int x, int y){
        nums = new boolean[9];
        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++){
                nums[map[i][j] - 1] = true;
            }
        }
        if(!isAllNums()) return false;
        return true;
    }

    private static boolean isAllNums(){
        for(int i = 0; i < 9; i++){
            if(!nums[i]) return false;
        }
        return true;
    }
}
