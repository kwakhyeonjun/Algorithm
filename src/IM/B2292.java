package IM;

import java.util.Scanner;

public class B2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        if(n==1) {
            System.out.println(1);
            return;
        }
        for(int i = 0; i <= n; i++){
            if(3*i*(i-1)+1 >= n && 3*(i-1)*(i-2)+1 < n) {
                System.out.println(i);
                return;
            }
        }
    }
}
