package Baekjoon.Levels.level07;

import java.util.Scanner;

public class B2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int Aunit = A%10;
        int Aten = (A%100)/10;
        int Ahunds = A/100;
        int Bunit = B%10;
        int Bten = (B%100)/10;
        int Bhunds = B/100;
        int newA = 100 * Aunit + 10 * Aten + Ahunds;
        int newB = 100 * Bunit + 10 * Bten + Bhunds;
        if(newA > newB) System.out.println(newA);
        else System.out.println(newB);
    }
}
