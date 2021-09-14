package Practice.part01.Day07;

import java.io.*;
import java.util.StringTokenizer;

public class B2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        for(int t = 0; t < n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = x; i < x + 10; i++){
                for(int j = y; j < y + 10; j++){
                    arr[i][j]++;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(arr[i][j] > 0) count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
