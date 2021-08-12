package Baekjoon.Grade.Silver;

import java.io.*;
import java.util.StringTokenizer;

public class B2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] stuff = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(getDel(stuff, 1)));
        bw.flush();
        bw.close();
        br.close();

    }
    private static int getDel(int[][] stuff, int flag){
        int min = Integer.MAX_VALUE;
        while(flag < Math.pow(2, stuff.length)){
            int sour = 1;
            int bitter = 0;
            int bit = flag;
            for(int i = 0; i < stuff.length; i++){
                if((bit & 1) == 1){
                    sour *= stuff[i][0];
                    bitter += stuff[i][1];
                }
                bit = bit >> 1;
            }
            min = Math.min(min, Math.abs(sour - bitter));
            flag++;
        }
        return min;
    }
}
