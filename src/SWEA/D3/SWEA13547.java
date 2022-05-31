package SWEA.D3;

import java.util.Scanner;

/**
 * 소 vs 세
 * o : 소
 * x : 세
 * 15번째 게임까지 진행했을 때, 점심값 면제 가능?
 */
public class SWEA13547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {

            String s = sc.next();
            char[] input = s.toCharArray();

            int so = 0, se = 0, rest = 15 - input.length;
            for(int i = 0; i < input.length; i++) {
                if(input[i] == 'o') so++;
                else se++;
            }
            so += rest;

            System.out.println("#" + t + " " + (so>se?"YES":"NO"));
        }
    }
}
