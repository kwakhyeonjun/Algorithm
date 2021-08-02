package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int[] score = new int[101];
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 1000; i++){
                score[Integer.parseInt(st.nextToken())]++;
            }
            int max = 0;
            int result = 0;
            for(int i = 0 ; i <= 100; i++){
                if(max <= score[i]){
                    max = score[i];
                    result = i;
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
