package SWEA.D2;

import java.util.Scanner;

public class SWEA1959_ver2 {
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
            int sum, max = 0;
            // 1. M > N
            for(int k = 0; k < M - N + 1; k++){
                sum = 0;
                for(int i = 0; i < N; i++) sum += arr1[i] * arr2[i + k];
                sum = Math.max(max, sum);
            }
            // 2. N > M
            for(int k = 0; k < N - M + 1; k++){
                sum = 0;
                for(int i = 0; i < M; i++) sum += arr1[i+k] * arr2[i];
                sum = Math.max(max, sum);
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}
