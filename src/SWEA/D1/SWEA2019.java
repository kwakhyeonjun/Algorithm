package SWEA.D1;

import java.util.Scanner;

public class SWEA2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int two = 1;
        for(int i = 0; i <= n; i++){
            System.out.print(two + " ");
            two *= 2;
        }
    }
}
