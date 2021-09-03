package Baekjoon.Grade.Bronze;

import java.util.Scanner;

public class B2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibo = new int[50];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2 ;i <= n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        System.out.println(fibo[n]);
    }
}
