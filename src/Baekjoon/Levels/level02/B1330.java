package Baekjoon.Levels.level02;/*
두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class B1330 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int A, B;
        A = sc.nextInt();
        B = sc.nextInt();

        if(A>B) System.out.println(">");
        else if(A<B) System.out.println("<");
        else System.out.println("==");

    }
}
