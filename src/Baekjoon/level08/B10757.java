package Baekjoon.level08;

import java.util.Scanner;

public class B10757 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int i = 1;
        int roundUp = 0;
        StringBuffer sb = new StringBuffer();
        while(true){
            int a, b;
            if(str1.length() < i){
                a = 0;
            }else{
                a = str1.charAt(str1.length() - i) - '0';
            }
            if(str2.length() < i){
                b = 0;
            } else {
                b = str2.charAt(str2.length() - i) - '0';
            }
            if(str1.length() < i && str2.length() < i) break;
            int sum = a + b + roundUp;
            roundUp = sum/10;
            sum %= 10;
            sb.append((char)(sum + '0'));
            i++;
        }
        if(roundUp == 1) sb.append(1);
        for(int j = 1; j <= sb.length(); j++){
            System.out.print(sb.charAt(sb.length() - j));
        }
    }
}
