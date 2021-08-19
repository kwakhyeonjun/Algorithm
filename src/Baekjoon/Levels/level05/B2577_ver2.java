package Baekjoon.Levels.level05;

import java.util.Scanner;

public class B2577_ver2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
        int mult = A * B * C;
        int[] arr = new int[10];
        String sMult = Integer.toString(mult);
        for(int i = 0; i < sMult.length(); i++){
            arr[(sMult.charAt(i) - '0')]++;
        }
        for(int v : arr) System.out.println(v);
    }
}