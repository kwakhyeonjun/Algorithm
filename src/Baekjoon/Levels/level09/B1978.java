package Baekjoon.Levels.level09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String inputStr = br.readLine();
        StringTokenizer st = new StringTokenizer(inputStr);
        int count = 0;
        for(int i = 0; i < N; i++){
            if(isPrime(Integer.parseInt(st.nextToken()))){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isPrime(int n){
        if(n==1) return false;
        for(int i = 2 ; i < n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
