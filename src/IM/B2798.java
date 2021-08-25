package IM;

import java.util.Scanner;

public class B2798 {
    private static int N, M;
    private static int[] deck;
    private static int[] picked = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        deck = new int[N];
        for(int i = 0; i < N; i++){
            deck[i] = sc.nextInt();
        }
        comb(0, 0);
        System.out.println(max);
    }

    private static int max;

    private static void comb(int count, int start){
        if(count == 3){
            int sum = 0;
            for(int i = 0 ; i < 3; i++){
                sum += picked[i];
            }
            if(sum > max && sum <= M) max = sum;
        }else{
            for(int i = start; i < N; i++){
                picked[count] = deck[i];
                comb(count+1, i+1);
            }
        }
    }
}
