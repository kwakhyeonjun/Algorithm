package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[401][401];

        map[1][1] = 1;
        int diff = 0;
        for(int i = 2; i <= 400; i++){
            map[i][1] = map[i-1][1] + ++diff;
        }

        diff = 0;
        int diff2 = 0;
        for(int i = 1; i <= 400; i++){
            diff2 = ++diff;
            for(int j = 2; j <= 400; j++){
                map[i][j] = map[i][j-1] + ++diff2;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = 0;
            int y = 0;
            for(int i = 1; i <= 400; i++){
                for(int j = 1; j <= 400; j++){
                    if(map[i][j] == a){
                        x += i;
                        y += j;
                    }
                    if(map[i][j] == b){
                        x += i;
                        y += j;
                    }
                }
            }
            System.out.println("#" + test_case + " " + map[x][y]);
        }
    }
}
