package IM;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] stuff = new int[N];
            for(int i = 0; i < N; i++){
                stuff[i] = Integer.parseInt(st.nextToken());
            }
            long price = 0;
            int max = stuff[N-1];
            for(int i = N-2; i>=0; i--){
                if(stuff[i] > max) max = stuff[i];
                else price += max - stuff[i];
            }

            bw.write("#" + test_case + " " + price + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
