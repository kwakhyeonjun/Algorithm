package Baekjoon.Grade.Silver;

import java.io.*;
import java.util.StringTokenizer;

public class B1010 {
    private static int N, M, tot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            tot = 0;

            comb(0, 0);

//            long up = 1;
//            for(int i = M-N+1; i <= M; i++){
//                up *= i;
//            }
//            long down = 1;
//            for(int i = 1; i <= N; i++){
//                down *= i;
//            }
//            bw.write(up/down + "\n");

            bw.write(tot + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }



    private static void comb(int start, int count){
        if(count == N){
            tot++;
            return;
        }else{
            for(int i = start; i < M; i++){
                comb(i + 1, count + 1);
            }
        }
    }
}