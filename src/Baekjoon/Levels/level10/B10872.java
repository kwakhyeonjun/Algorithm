package Baekjoon.Levels.level10;

import java.io.*;

public class B10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(factorial(N));
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int factorial(int n){
        if(n==1 || n==0) return 1;
        return n * factorial(n-1);
    }

    private static int factorialWithFor(int n){
        int result = 1;
        for(int i = 1; i <= n; i++)
            result *= i;
        return result;
    }
}
