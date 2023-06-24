package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String s = Integer.toBinaryString(n);
            for (int i = s.length() - 1; i >= 0; i--) {
                if(s.charAt(i) == '1') System.out.print((s.length() - i  - 1)+ " ");
            }
        }
    }
}
