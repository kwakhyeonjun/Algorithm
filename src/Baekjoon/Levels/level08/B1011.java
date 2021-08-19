package Baekjoon.Levels.level08;

import java.util.Scanner;

public class B1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = end - start;

            int max = (int)Math.sqrt(distance);

            if(max == Math.sqrt(distance)) System.out.println(max*2 - 1);
            else if(distance <= max * max + max)
                System.out.println(max*2);
            else
                System.out.println(max*2+1);
        }
    }
}
