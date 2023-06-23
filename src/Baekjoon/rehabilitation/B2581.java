package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int num = Integer.MAX_VALUE;
        for (int i = m; i < n + 1; i++) {
            if(isPrime(i)) {
                answer += i;
                num = Math.min(num, i);
            }
        }
        if(num == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
        System.out.println(num);
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for (int i = 2; i*i <= n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}
