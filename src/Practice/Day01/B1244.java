package Practice.Day01;

import java.util.Scanner;

public class B1244 {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        arr = new int[size + 1];
        for(int i = 1; i <= size; i++){
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        for(int p = 0; p < n; p++){
            int isMale = sc.nextInt();
            int input = sc.nextInt();
            if(isMale == 1){
                for(int i = input; i <= size; i += input){
                    change(i);
                }
            }else{
                change(input);
                for(int i = 1; i <= size; i++){
                    if(input-i < 1 || input+i > size) break;
                    if(arr[input+i] != arr[input-i]){
                        break;
                    }
                    change(input+i);
                    change(input-i);
                }
            }
        }
        for(int i = 1; i <= size; i++){
            System.out.print(arr[i] + " ");
            if(i%20 == 0) System.out.println();
        }
    }
    public static void change(int idx){
        if(arr[idx] == 0) arr[idx] = 1;
        else arr[idx] = 0;
    }
}
