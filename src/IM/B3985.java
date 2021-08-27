package IM;

import java.util.Scanner;

public class B3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        boolean[] roll = new boolean[L+1];
        int expectedSum = 0;
        int expected = 0;
        int real = 0;
        int realSum = 0;
        for(int i = 1; i <= N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int count = 0;
            if(end - start + 1 > expectedSum){
                expectedSum = end - start + 1;
                expected = i;
            }
            for(int j = start; j <= end; j++){
                if(!roll[j]){
                    roll[j] = true;
                    count++;
                }
            }
            if(realSum < count){
                realSum = count;
                real = i;
            }
        }
        System.out.println(expected + "\n" + real);
    }
}
