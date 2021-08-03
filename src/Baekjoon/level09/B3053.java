package Baekjoon.level09;

import java.util.Scanner;

/**
 * 유클리드 기하학에서 원은 동그란 모양 == 원주율 필요
 * 택시 기하학에서 원은 마름모 모양(2d*2d/2)
 */
public class B3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        System.out.printf("%.6f\n", d*d*Math.PI);
        System.out.printf("%d.000000\n", 2*d*d);
    }
}
