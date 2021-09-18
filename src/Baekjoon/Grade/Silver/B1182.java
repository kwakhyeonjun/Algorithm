package Baekjoon.Grade.Silver;

import java.util.Scanner;

public class B1182 {
    private static int N, S;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        pick = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        comb(0, 0);
        System.out.println(answer);
    }

    private static int answer;
    private static int[] pick;

    private static void comb(int count, int start){
        if(count > 0){
            int sum = 0;
            for(int i = 0; i < count; i++){
                sum += pick[i];
            }
            if(sum == S) answer++;
        }
        for(int i = start; i < N; i++){
            pick[count] = arr[i];
            comb(count + 1, i + 1);
        }
    }
}