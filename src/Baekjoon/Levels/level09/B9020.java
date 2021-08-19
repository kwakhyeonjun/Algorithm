package Baekjoon.Levels.level09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for(int i = 2; i <= n/2; i++){
                if(isPrime(i)){
                    if(isPrime(n-i)) result = i;
                }
            }
            System.out.println(result + " " + (n - result));
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
