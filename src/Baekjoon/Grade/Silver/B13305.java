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
        int i = 1;
        int pivot = 0;
        int answer = 0;
        int sum = 0;
        while(i < N){
            if(prices[pivot] <= prices[i]){
                sum += dist[i-1];
                i++;
            }else {
                answer += prices[pivot] * sum;
                sum = 0;
                pivot = i;
                i++;
            }
        }
        answer += prices[pivot] * sum;
        System.out.println(answer);
    }
}
