package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr1 = new int[N];
            int[] arr2 = new int[M];
            for(int i = 0; i < N; i++) arr1[i] = sc.nextInt();
            for(int i = 0; i < M; i++) arr2[i] = sc.nextInt();
            int[] small;
            int[] large;
            if(N > M){
                small = Arrays.copyOf(arr2, M);
                large = Arrays.copyOf(arr1, N);
            }else{
                small = Arrays.copyOf(arr1, N);
                large = Arrays.copyOf(arr2, M);
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < large.length - small.length + 1; i++){
                int sum = 0;
                for(int j = 0; j < small.length; j++){
                    sum += (small[j] * large[i+j]);
                }
                max = Math.max(max, sum);
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}
