package Baekjoon.Grade.Silver;

import java.io.*;

public class B2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max_five = N/5;

        int five = max_five;
        for(int i = max_five; i >= 0; i--){
            int rest = N - (5*five);
            if(rest % 3 == 0){
                int three = rest/3;
                if(min > five + three) min = five + three;
            }else{
                five = i-1;
            }
        }
        bw.write(min == Integer.MAX_VALUE ? "-1" : String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }
}
