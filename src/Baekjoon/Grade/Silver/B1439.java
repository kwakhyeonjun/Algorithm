package Baekjoon.Grade.Silver;

import java.util.Scanner;

public class B1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int[] count = new int[2];

        count[S.charAt(0) - '0']++;
        for(int i = 0; i < S.length() - 1; i++){
            if(S.charAt(i) != S.charAt(i+1)){
                count[S.charAt(i+1) - '0']++;
            }
        }
        System.out.println(Math.min(count[0], count[1]));
    }
}
