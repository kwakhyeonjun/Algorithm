package Baekjoon.Grade.Silver;

import java.util.Arrays;
import java.util.Scanner;

public class B2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(arithmeticMean(arr));
        System.out.println(median(arr));
        System.out.println(mode(arr));
        System.out.println(range(arr));
    }

    private static int arithmeticMean(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (int) Math.round((double)sum/arr.length);
    }

    private static int median(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

    private static int mode(int[] arr){
        int[] nums = new int[8001];
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i] + 4000]++;
        }
        int max = 0;
        int answer = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= max && nums[i] != 0 && count < 2){
                max = nums[i];
                answer = i;
                count++;
            }
        }
        return answer - 4000;
    }

    private static int range(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min;
    }
}
