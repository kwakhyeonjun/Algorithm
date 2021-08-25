package IM;

import java.util.Scanner;

public class B2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int result = 0;
        for(int i = 0; i < 9; i++){
            int current = sum + sc.nextInt();
            if(Math.abs(current-100) <= Math.abs(sum - 100)){
                sum = current;
            }else{
                break;
            }
        }
        System.out.println(sum);
    }
}
