package Baekjoon.Grade.Silver;

import java.util.Scanner;

public class B1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        int index = 1;
        int count = 0;
        while(index <= S){
            S -= index;
            index++;
            count++;
        }
        System.out.println(count);
    }
}
