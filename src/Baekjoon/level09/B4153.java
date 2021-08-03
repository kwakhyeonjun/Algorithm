package Baekjoon.level09;

import java.util.Arrays;
import java.util.Scanner;

public class B4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] triangle = new int[3];
        while((triangle[0] = sc.nextInt()) != 0
                && (triangle[1] = sc.nextInt()) != 0
                && (triangle[2] = sc.nextInt()) != 0){
            Arrays.sort(triangle);
            if(triangle[2]*triangle[2]
                    == triangle[1]*triangle[1] + triangle[0]*triangle[0]){
                System.out.println("right");
            }else
                System.out.println("wrong");

        }
    }
}
