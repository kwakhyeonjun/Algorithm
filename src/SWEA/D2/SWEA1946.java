package SWEA.D2;

import java.util.Scanner;

public class SWEA1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            System.out.println("#" + test_case);
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++){
                String str = sc.next();
                arr[i][0] = str.charAt(0) - 'A';
                arr[i][1] = sc.nextInt();
            }
            int lineIdx = 1;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[i][1]; j++){
                    char c = (char)('A' + arr[i][0]);
                    System.out.print(c);
                    lineIdx++;
                    if(lineIdx > 10){
                        System.out.println();
                        lineIdx = 1;
                    }
                }
            }
            System.out.println();
        }
    }
}
