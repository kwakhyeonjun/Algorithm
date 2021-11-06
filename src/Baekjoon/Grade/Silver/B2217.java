package Baekjoon.Grade.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class B2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] rope = new int[N];
        for (int i = 0; i < N; i++) {
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope);
        long answer = 0;
        for(int i = N - 1; i >= 0; i--){
            rope[i] = rope[i] * (N - i);
            answer = Math.max(answer, rope[i]);
        }
        System.out.println(answer);
    }
}
