package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] room = new int[7][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            room[Y][S]++;
        }

        int count = 0;
        for(int i = 1; i < 7; i++){
            for(int j = 0; j < 2; j++){
                if(room[i][j]%K != 0) count += room[i][j]/K + 1;
                else count += room[i][j]/K;
            }
        }
        System.out.println(count);
    }
}
