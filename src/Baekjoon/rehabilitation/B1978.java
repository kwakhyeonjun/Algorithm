package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(input[i]);
            if(isPrime(cur)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for (int i = 2; i*i <= n ; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}
