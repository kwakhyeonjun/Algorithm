package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int gcd = gcd(a, b);

        System.out.println(gcd);
        System.out.println(b * (a / gcd));
    }

    private static int gcd(int a, int b) {
        while(true) {
            if(a % b == 0) return b;
            a = a % b;
            if(b % a == 0) return a;
            b = b % a;
        }
    }
}
