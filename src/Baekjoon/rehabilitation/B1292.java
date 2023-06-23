package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int[] arr = makeArr(b);
        int sum = 0;
        for (int i = a -1; i < b; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    private static int[] makeArr(int b) {
        int[] arr = new int[b + 1];
        int count = 0;
        int idx = 1;
        for (int i = 0; i < b + 1; i++) {
            arr[i] = idx;
            count++;
            if(idx == count) {
                idx++;
                count = 0;
            }
        }
        return arr;
    }
}
