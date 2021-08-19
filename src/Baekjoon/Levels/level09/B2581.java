package Baekjoon.Levels.level09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = M; i <= N; i++){
            if(isPrime(i)){
                list.add(i);
                sum+=i;
            }
        }
        if(list.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(list.get(0));
        }
    }
    public static boolean isPrime(int n){
        if(n == 1) return false;
        for(int j = 2; j < n; j++){
            if(n%j == 0) return false;
        }
        return true;
    }
}
