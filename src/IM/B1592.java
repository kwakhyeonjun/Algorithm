package IM;

import java.util.Scanner;

public class B1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] ball = new int[N];
        int count = 0;
        int n = 0;
        int next = 0;
        while(true){
            ball[n]++;
            if(ball[n] == M) break;
            if(ball[n]%2 != 0){
                next = (n+L)%N;
            }else{
                next = (n-L);
                if(next < 0) next = N + next;
            }
            n = next;
            count++;
        }
        System.out.println(count);
    }
}
