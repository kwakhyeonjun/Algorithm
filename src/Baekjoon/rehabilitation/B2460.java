package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int train = 0;
        int MAX = 0;
        for (int t = 0; t < 10; t++) {
            String[] input = br.readLine().split(" ");
            int out = Integer.parseInt(input[0]);
            int in = Integer.parseInt(input[1]);

            train -= out;
            MAX = Math.max(MAX, train);
            train += in;
            MAX = Math.max(MAX, train);
        }
        System.out.println(MAX);
    }
}
