package SWEA.D2;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA1285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int count = 1;
            int min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int curDist = Math.abs(Integer.parseInt(st.nextToken()));
                if(min >= curDist) {
                    if(min == curDist) count++;
                    else {
                        count = 1;
                        min = curDist;
                    }
                }
            }
            System.out.printf("#%d %d %d", test_case, min, count);
        }
        br.close();
    }
}
