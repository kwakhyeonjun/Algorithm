package Baekjoon.Grade.Silver;

import java.io.*;
import java.util.StringTokenizer;

public class B4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if( L == 0 && P == 0 && V == 0 ) break;

            int answer = 0;
            int pos = V/P;
            answer += pos*L;
            V -= pos * P;
            if(V > L){
                answer += L;
            }else {
                answer += V;
            }

            bw.write("Case " + test_case + ": " + answer + "\n");
            test_case++;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
