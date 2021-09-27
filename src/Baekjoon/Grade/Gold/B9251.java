package Baekjoon.Grade.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();


        int[] counts = new int[s1.length];
        for (int k = 0; k < s1.length; k++) {
            int pointer = 0;
            int curCount = 0;
            for (int i = k; i < s1.length; i++) {
                for (int j = pointer; j < s2.length; j++) {
                    if(s1[i] == s2[j]){
                        curCount++;
                        pointer = j;
                        break;
                    }
                }
            }
            counts[k] = curCount;
        }

        int answer = 0;
        for (int i = 0; i < counts.length; i++) {
            answer = Math.max(answer, counts[i]);
        }
        System.out.println(answer);
        br.close();
    }
}
