package IM;

import java.util.Scanner;

public class B8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;
        int i = 1;
        while(n/i -i+1> 0){
            sum += n/i - i+1;
            i++;
        }
        System.out.println(sum);

    }
}
