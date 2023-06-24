package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(split[i]);
            MAX = Math.max(MAX, cur);
            MIN = Math.min(MIN, cur);
        }
        System.out.println(MIN + " " + MAX);


    }
}
