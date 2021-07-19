package Baekjoon.level07;

import java.util.Scanner;

public class B11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = s.charAt(i) - '0';
        }
        int sum = 0;
        for(int v : arr) sum += v;
        System.out.println(sum);
    }
}
