package SWEA.D2;

import java.util.Scanner;

public class SWEA1945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {2, 3, 5, 7, 11};
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int[] arr = new int[5];
            for(int i = 0; i < numbers.length; i++){
                while(N%numbers[i] == 0){
                    arr[i]++;
                    N /= numbers[i];
                }
            }
            System.out.print("#" + test_case + " ");
            for(int i = 0; i < 5; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
