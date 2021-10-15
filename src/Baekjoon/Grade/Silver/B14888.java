package Baekjoon.Grade.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
    private static int N, min, max;
    private static int[] A, operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        picked = new int[N-1];
        perm(0);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    private static int[] picked;

    private static void perm(int count){
        if(count == N-1){
            int sum = A[0];
            for (int i = 0; i < N - 1; i++) {
                switch (picked[i]){
                    case 0:
                        sum += A[i+1];
                        break;
                    case 1:
                        sum -= A[i+1];
                        break;
                    case 2:
                        sum *= A[i+1];
                        break;
                    case 3:
                        sum /= A[i+1];
                        break;
                }
            }
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }else{
            for (int i = 0; i < 4; i++) {
                if(operators[i] == 0) continue;
                picked[count] = i;
                operators[i]--;
                perm(count + 1);
                operators[i]++;
            }
        }
    }
}
