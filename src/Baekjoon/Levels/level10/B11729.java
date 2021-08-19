package Baekjoon.Levels.level10;

import java.io.*;

public class B11729 {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        sb.append((int)(Math.pow(2, n) - 1)).append("\n");

        hanoi(n, 1, 2, 3);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void hanoi(int n, int start, int mid, int to){
        if(n == 1){
            sb.append(start + " " + to + "\n");
            return;
        }
        // n-1개를 A에서 B로 이동
        hanoi(n-1, start, to, mid);

        sb.append(start + " " + to + "\n");

        // n-1개를 B에서 C로 이동
        hanoi(n-1, mid, start, to);

    }
}
