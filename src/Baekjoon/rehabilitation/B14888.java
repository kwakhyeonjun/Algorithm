package Baekjoon.rehabilitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14888 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        op = new int[4];
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(input[i]);
        }
        picked = new int[n - 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        comb(0, 0);
        System.out.println(max);
        System.out.println(min);

    }

    private static int n, max, min;
    private static int[] picked, op, arr;

    private static void comb(int start, int count) {
        if(count == n - 1) {
            int sum = arr[0];
            for (int i = 0; i < n - 1; i++) {
                if(picked[i] == 0) {
                    sum += arr[i + 1];
                }else if(picked[i] == 1) {
                    sum -= arr[i + 1];
                }else if (picked[i] == 2) {
                    sum *= arr[i + 1];
                } else {
                    sum = div(sum, arr[i + 1]);
                }
            }
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = start; i < n - 1; i++) {
            for (int j = 0; j < 4; j++) {
                if(op[j] == 0) continue;
                picked[i] = j;
                op[j]--;
                comb(i + 1, count + 1);
                op[j]++;
            }
        }
    }

    private static int div(int a, int b) {
        if (a < 0) {
            return (a * -1)/b * -1;
        }
        return a / b;
    }
}
