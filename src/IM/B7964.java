package IM;

import java.io.*;
import java.util.StringTokenizer;

public class B7964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] map = new int[N];
            int count = 0, idx = 0;
            for(int i = 0; i < N; i++){
                map[i] = Integer.parseInt(st.nextToken());
                if(map[i] == 1) idx = i;
            }

            int go = D - 1;
            for(int i = idx; i >= 0; i--) {
                if(map[i] == 1) {
                    go = D - 1;
                }
                else if(go == 0) {
                    map[i] = 1;
                    count++;
                    go = D -1;
                }
                else {
                    go--;
                }
            }

            for(int i = idx; i < N; i++) {
                if(map[i] == 1) {
                    go = D - 1;
                }
                else if(go == 0) {
                    map[i] = 1;
                    count++;
                    go = D - 1;
                }
                else {
                    go--;
                }
            }


            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
