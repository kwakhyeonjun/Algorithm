package Baekjoon.Grade.Gold;

import java.util.Arrays;
import java.util.Scanner;

public class B1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] <= 0 && arr[i+1] <= 0) {
                answer += arr[i] * arr[i + 1];
                continue;
            }else if(arr[i] <= 0){
                answer += arr[i];
                continue;
            }
            if(arr[i] > 1){
                answer += arr[i] * arr[i+1];
                continue;
            }
            answer += arr[i];
        }
        System.out.println(answer);
    }
}
