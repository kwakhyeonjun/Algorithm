package Baekjoon.level07;

import java.util.Scanner;

public class B2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int n = sc.nextInt();
            String s = sc.next();
            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < n; j++){
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
