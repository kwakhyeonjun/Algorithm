package Codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE2017AM01 {
    private static final int MAX_N = 11;
    private static int n, max = -1_000_000_000, min = 1_000_000_000;
    private static final int[] num = new int[MAX_N];
    private static final int[] op = new int[3];
    private static int[] picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(split[i]);
        }

        split = br.readLine().split(" ");

        for (int i = 0; i < 3; i++) {
            op[i] = Integer.parseInt(split[i]);
        }

        picked = new int[n - 1];
        int[] opCount = new int[3];
        comb(opCount, 0);

        System.out.println(min + " " + max);
    }

    private static void comb(int[] opCount, int count) {
        if(count == n - 1) {
            cal();
            return;
        }
        for (int i = 0; i < 3; i++) {
            if(opCount[i] >= op[i]) continue;
            picked[count] = i;
            opCount[i]++;
            comb(opCount, count + 1);
            opCount[i]--;
        }
    }

    private static void cal() {
        int sum = num[0];
        for (int i = 0; i < n - 1; i++) {
            if(picked[i] == 0) {
                sum += num[i + 1];
            } else if(picked[i] == 1) {
                sum -= num[i + 1];
            } else {
                sum *= num[i + 1];
            }
        }
        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }
}
