package Baekjoon.level11;

import java.io.*;
import java.util.StringTokenizer;

public class B2798 {
    private static int N, m, max;
    private static int[] result = new int[3];
    private static int[] deck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        deck = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            deck[i] = Integer.parseInt(st.nextToken());
        }
        comb(0, 0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void comb(int count, int start){
        if(count == 3){
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += result[i];
            }
            if(sum > max && sum <= m) max = sum;
            return;
        }else{
            for(int i = start; i < N; i++){
                result[count] = deck[i];
                comb(count+1, i+1);
            }
        }
    }
}
