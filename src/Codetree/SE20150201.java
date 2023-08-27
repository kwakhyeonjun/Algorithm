package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE20150201 {
    private static final int MAX_N = 1_000_000;
    private static final int[] shop = new int[MAX_N];
    private static int n, leader, member;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            shop[i] = Integer.parseInt(split[i]);
        }

        split = br.readLine().split(" ");

        leader = Integer.parseInt(split[0]);
        member = Integer.parseInt(split[1]);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer++;
            shop[i] -= leader;

            if(shop[i] <= 0) continue;

            if(shop[i] % member == 0) answer--;
            answer += (shop[i] / member) + 1;
        }

        System.out.println(answer);
    }
}
