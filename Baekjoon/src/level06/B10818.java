package level06;

import java.util.Scanner;

public class B10818 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        int min = array[0], max = array[0];
        for(int i = 1; i < N; i ++){
            if(min>array[i]) min = array[i];
            if(max<array[i]) max = array[i];
        }
        System.out.println(min + " " + max);
    }
}
