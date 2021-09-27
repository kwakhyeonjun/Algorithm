package Baekjoon.Grade.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        int[] profits = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        int[][] D = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if(w >= weights[i]){
                    D[i][w] = Math.max(D[i-1][w], profits[i] + D[i-1][w - weights[i]]);
                }else{
                    D[i][w] = D[i-1][w];
                }
            }
        }

        System.out.println(D[N][K]);
        br.close();
    }
}
