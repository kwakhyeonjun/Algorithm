package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[9];
        for (int t = 0; t < 9; t++) {
            dwarf[t] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarf);
        picked = new int[7];
        answer = new int[7];
        comb(0, 0);
        for(int n : answer) {
            System.out.println(n);
        }
    }
    private static int[] dwarf;
    private static int[] picked;
    private static int[] answer;

    private static void comb(int start, int count) {
        if(count == 7) {
            int sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += dwarf[picked[i]];
            }
            if(sum == 100) {
                for(int i = 0; i < 7; i++) {
                    answer[i] = dwarf[picked[i]];
                }
            }
            return;
        }
        for(int i = start; i < 9; i++) {
            picked[count] = i;
            comb(i + 1, count + 1);
        }
    }
}
