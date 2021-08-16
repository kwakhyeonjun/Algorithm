package Baekjoon.Grade.Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int mul = 1;
            for(int i = 0; i < b; i++){
                mul *= a;
                mul %= 10;
            }
            if(mul == 0) mul = 10;
            bw.write(String.valueOf(mul));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
