package level05;

import java.util.Scanner;

public class B3052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = sc.nextInt();
            arr[i] %= 42;
        }
        int[] count = new int[42];
        for(int i = 0; i < 10; i++){
            count[arr[i]]++;
        }
        int result = 0;
        for(int v : count){
            if(v > 0) result++;
        }
        System.out.println(result);
    }
}
