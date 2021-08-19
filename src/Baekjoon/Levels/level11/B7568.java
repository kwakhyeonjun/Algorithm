package Baekjoon.Levels.level11;

import java.io.*;
import java.util.StringTokenizer;

public class B7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] person = new int[N][2];
        int[] rank = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i==j) continue;
                if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) rank[i]++;

            }
        }

        for(int i = 0; i < N; i++){
            bw.write(rank[i] + 1 + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
