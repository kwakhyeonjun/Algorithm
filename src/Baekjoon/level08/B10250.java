package Baekjoon.level08;

import java.util.Scanner;

public class B10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            if(N%H == 0){
                System.out.println((H * 100) + (N / H));
            }
            else{
                System.out.println(((N % H) * 100) + ((N / H) + 1));
            }
        }
    }
}
