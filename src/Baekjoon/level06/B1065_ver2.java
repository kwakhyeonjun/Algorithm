package Baekjoon.level06;

import java.util.Scanner;

public class B1065_ver2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(func(i)) count++;
        }
        System.out.println(count);
    }

    /**
     * 문제점 개량버전
     * @param n
     * @return
     */
    static boolean func(int n){
        boolean result = false;
        if(n<100) result = true;
        else{
            int first = (n%100)/10 - n%10;
            int second = (n%1000)/100 - (n%100)/10;
            if(first == second) result = true;
        }
        if(n==1000) result = false;
        return result;
    }
}

/**
 * int n;
 * n's unit = n%10
 * n's tens = (n%100)/10
 * n's hunds = (n%1000)/100
 * ...
 */
