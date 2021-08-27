package IM;

import java.util.Arrays;
import java.util.Scanner;

public class B11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int[] p = new int[N];
        for(int i = 0; i < N; i++){
            p[i] = sc.nextInt();
        }
        Arrays.sort(p);
        int prev = 0;
        for(int i = 0; i < N; i++){
            sum += prev + p[i];
            prev += p[i];
        }
        System.out.println(sum);
    }
}
