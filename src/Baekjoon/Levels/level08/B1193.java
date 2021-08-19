package Baekjoon.Levels.level08;

import java.util.Scanner;

public class B1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cross = 1, prev_sum = 0;
        while (true) {
            if(N <= prev_sum + cross){
                if(cross%2 == 1) {
                    System.out.println((cross - (N - prev_sum - 1)) + "/" + (N - prev_sum));
                    break;
                }else{
                    System.out.println((N - prev_sum) + "/" + (cross - (N - prev_sum - 1)));
                    break;
                }
            }else{
                prev_sum += cross;
                cross++;
            }
        }
    }
}
