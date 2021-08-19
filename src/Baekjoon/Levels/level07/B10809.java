package Baekjoon.Levels.level07;

import java.util.Scanner;

public class B10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[26];
        for(int i = 0; i < 26; i++){
            arr[i] = -1;
        }
        for(int i = 0; i < s.length(); i++){
            int alphabet = s.charAt(i) - 'a';
            if(arr[alphabet] == -1) arr[alphabet] = i;
        }
        for(int v : arr) System.out.print(v + " ");
    }
}
