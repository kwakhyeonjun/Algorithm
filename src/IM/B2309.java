package IM;

import java.util.Arrays;
import java.util.Scanner;

public class B2309 {
    private static int[] dwarf = new int[9];
    private static int[] picked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            dwarf[i] = sc.nextInt();
        }
        picked = new int[7];
        comb(0, 0);
    }

    private static void comb(int start, int count){
        if(count == 7){
            int sum = 0;
            for(int v : picked) sum += v;
            if(sum != 100) return;
            Arrays.sort(picked);
            for(int i = 0 ; i < 7; i++){
                System.out.println(picked[i]);
            }
            return;
        }else{
            for(int i = start; i < 9; i++){
                picked[count] = dwarf[i];
                comb(i+1, count+1);
            }
        }
    }
}
