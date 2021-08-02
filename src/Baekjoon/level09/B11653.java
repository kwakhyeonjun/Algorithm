package Baekjoon.level09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 2;
        StringBuilder sb = new StringBuilder();
        if(N != 1){
            while(N != 1){
                if(N%i == 0) {
                    sb.append(i).append("\n");
                    N /= i;
                }
                else i++;
            }
            System.out.println(sb);
        }
    }
}
