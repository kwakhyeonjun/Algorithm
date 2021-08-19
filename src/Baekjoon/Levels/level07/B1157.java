package Baekjoon.Levels.level07;

import java.util.Scanner;

public class B1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.toUpperCase();
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++){
            alphabet[s.charAt(i) - 'A']++;
        }
        int max = Integer.MIN_VALUE, idx = 0;
        for(int i = 0; i < 26; i++){
            if(max < alphabet[i]) {
                max = alphabet[i];
                idx = i;
            }
        }
        boolean isMany = false;
        for(int i = 0; i < 26; i++){
            if(max == alphabet[i] && idx != i) isMany = true;
        }
        if(isMany) System.out.println("?");
        else System.out.println((char) (idx + 'A'));
    }
}
