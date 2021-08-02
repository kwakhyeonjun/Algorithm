package Baekjoon.level09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int count = 0;
        while((n = Integer.parseInt(br.readLine())) != 0){
            for(int i = n+1; i <= 2*n; i++){
                if(isPrime(i)) count++;
            }
            System.out.println(count);
            count = 0;
        }
    }
    public static boolean isPrime(int n){
        if(n==1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
