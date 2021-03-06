package Baekjoon.Grade.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        char operand = '0';
        answer = 0;
        boolean minus = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') sb.append(s.charAt(i));
            else{
                if(operand == '-') minus = true;
                if(minus) answer -= Integer.parseInt(sb.toString());
                else answer += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                operand = s.charAt(i);
                if(operand == '-') minus = true;
            }
        }
        if(minus) answer -= Integer.parseInt(sb.toString());
        else answer += Integer.parseInt(sb.toString());
        System.out.println(answer);
        br.close();
    }
}
