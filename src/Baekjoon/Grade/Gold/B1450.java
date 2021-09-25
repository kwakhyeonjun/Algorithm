package Baekjoon.Grade.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1450 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] stuff = new int[N];
        int[] memo = new int[C + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stuff[i] = Integer.parseInt(st.nextToken());
        }

        memo[0] = 1;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                if(memo[j] > 0 && j + stuff[i] <= C) memo[j + stuff[i]] += memo[j];
            }
        }

        for (int i = 0; i <= C; i++) {
            answer += memo[i];
        }

        System.out.println(answer);
        br.close();
    }
}
