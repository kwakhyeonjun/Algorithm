package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        for(int i = 1; i <= N; i++) {
            if(N%i == 0) K--;
            if(K == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
