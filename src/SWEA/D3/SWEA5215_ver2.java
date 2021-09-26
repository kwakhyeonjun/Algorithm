package SWEA.D3;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA5215_ver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] stuffs = new int[N+1];
            int[] cals = new int[N+1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                stuffs[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }

            int[][] D = new int[N + 1][L + 1];
            for (int i = 1; i <= N; i++) {
                for (int w = 1; w <= L; w++) {
                    if(cals[i] <= w){
                        D[i][w] = Math.max(D[i-1][w], D[i - 1][w - cals[i]] + stuffs[i]);
                    }else{
                        D[i][w] = D[i-1][w];
                    }
                }
            }

            bw.write("#" + test_case + " " + D[N][L] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
