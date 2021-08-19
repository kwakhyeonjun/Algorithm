package Baekjoon.Levels.level08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2869 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        try{
            String[] input = br.readLine().split(" ");
            for(int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        int A = arr[0];
        int B = arr[1];
        int V = arr[2];
        int day = (V - B)/(A - B);
        if((V-B)%(A-B) != 0) day++;
        System.out.println(day);
    }
}
