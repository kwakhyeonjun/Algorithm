package Baekjoon.Grade.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
            D[i] = P[i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if(i - j >= T[j]){
                    D[i] = Math.max(P[i] + D[j], D[i]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(i + T[i] <= N + 1){
                if(answer < D[i]) answer = D[i];
            }

        }

        System.out.println(answer);
        br.close();
    }
}
