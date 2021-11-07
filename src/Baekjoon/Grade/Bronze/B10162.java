package Baekjoon.Grade.Bronze;

import java.util.Scanner;

public class B10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        if(T%10 != 0) {
            System.out.println(-1);
            return;
        }

        int[] times = {300, 60, 10};

        int[] answer = new int[3];
        for(int i = 0; i < 3; i++){
            answer[i] = T/times[i];
            T %= times[i];
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
