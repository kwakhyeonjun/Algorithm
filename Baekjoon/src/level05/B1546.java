package level05;

import java.util.Scanner;

public class B1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        double[] dArr = new double[N];
        arr[0] = sc.nextInt();
        int max = arr[0];
        for(int i = 1; i < N; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > max) max = arr[i];
        }
        for(int i = 0; i < N; i++){
            dArr[i] = arr[i] * 100;
            dArr[i] /= max;

        }
        double add = 0;
        for(int i = 0; i < N; i++){
            add += dArr[i];
        }
        double result = add/N;
        System.out.printf("%f", result);
    }
}
