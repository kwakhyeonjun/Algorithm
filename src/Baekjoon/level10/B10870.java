package Baekjoon.level10;

import java.io.*;

public class B10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] fibonacci = new int[21];
        for(int i = 1; i <= 20; i++){
            if(i == 1 || i == 2) fibonacci[i] = 1;
            else{
                fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
            }
        }
//        sb.append(fibonacci(n));
        sb.append(fibonacci[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static int fibonacci(int n){
        if(n==1 || n==2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
