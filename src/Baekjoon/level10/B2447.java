package Baekjoon.level10;

import java.io.*;

public class B2447 {

    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        print(0, 0, n, false);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static void print(int x, int y, int n, boolean isBlank){
        if(isBlank){
            for(int i = x; i < x + n; i++){
                for(int  j = y; j < y + n; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1){
            arr[x][y] = '*';
            return;
        }

        int size = n/3;
        int count = 0;
        for(int  i = x; i < x + n; i += size){
            for(int j = y; j < y + n; j += size){
                count++;
                if(count == 5){
                    print(i, j, size, true);
                }else{
                    print(i, j, size, false);
                }
            }
        }
    }
}
