package Baekjoon.level03;

import java.io.*;
import java.util.StringTokenizer;

public class B15552 {
    public static void main ( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader ( new InputStreamReader (System.in) );
        BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter ( System.out ) );

        int N = Integer.parseInt ( br.readLine () );

        for(int i = 0; i < N; i++){
            StringTokenizer to = new StringTokenizer ( br.readLine () );
            int A = Integer.parseInt ( to.nextToken() );
            int B = Integer.parseInt ( to.nextToken () );
            bw.write(String.valueOf ( A+B )+"\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}

