package Baekjoon.Grade.Bronze;

import java.util.Scanner;

public class B5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();

        int[] coins = {500, 100, 50, 10, 5, 1};

        int answer = 0;
        for(int i = 0; i < coins.length; i++){
            int count = money / coins[i];
            answer += count;
            money -= coins[i] * count;
        }
        System.out.println(answer);
    }
}