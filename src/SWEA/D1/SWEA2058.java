package SWEA.D1;

import java.util.Scanner;

public class SWEA2058 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < 4; i++){
            int temp = N%10;
            N /= 10;
            sum += temp;
        }
        System.out.println(sum);
    }
}
