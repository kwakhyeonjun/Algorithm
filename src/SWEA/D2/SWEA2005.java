package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int n = sc.nextInt();
            int[] arr = new int[1];
            arr[0] = 1;
            System.out.println("#" + test_case);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < arr.length; j++){
                    System.out.print(arr[j] + " ");
                }
                int[] temp = Arrays.copyOf(arr, arr.length + 1);
                temp[0] = 1;
                temp[temp.length-1] = 1;
                for(int j = 1; j < temp.length-1; j++){
                    temp[j] = arr[j] + arr[j-1];
                }
                arr = Arrays.copyOf(temp, temp.length);
                System.out.println();
            }
        }
    }
}
