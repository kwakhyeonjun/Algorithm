package Baekjoon.Grade.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        int[] prices = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int pivot = prices[0];
        int totDist = 0;
        for(int i = 1; i < prices.length; i++){
            if(i == prices.length - 1 || pivot > prices[i]){
                totDist += dist[i-1];
                answer += (long) totDist * pivot;
                totDist = 0;
                pivot = prices[i];
            }else{
                totDist += dist[i-1];
            }
        }
        System.out.println(answer);
    }
}
