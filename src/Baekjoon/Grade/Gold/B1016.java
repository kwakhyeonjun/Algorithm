package Baekjoon.Grade.Gold;

import java.util.Scanner;

public class B1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] times = new boolean[(int)(max - min)];
         int t = 1;
        for(int i = 2; i <= Math.sqrt(max); i++){
            double time = Math.pow(i, 2);
            while(t * time <= max){
                if(t*time >= min){
                    times[(int)(t*time - min)] = true;
                }
                t++;
            }
        }

        int answer = 0;
        for(int i = 0; i < times.length; i++){
            if(!times[i]) answer++;
        }
        System.out.println(answer);
    }
}
