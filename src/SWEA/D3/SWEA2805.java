package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            for(int i = 0; i < N; i++){
                String temp = br.readLine();
                for(int j = 0; j < N; j++){
                    farm[i][j] = temp.charAt(j) - '0';
                }
            }
            int mid = N/2;
            int sum = 0;
            for(int i = 0; i <= mid; i++){
                sum += farm[i][mid];
                for(int j = 1; j <= i; j++){
                    sum += farm[i][mid + j];
                    sum += farm[i][mid - j];
                }
            }
            for(int i = N - 1; i > mid; i--){
                sum += farm[i][mid];
                for(int j = 1; j < N-i; j++){
                    sum += farm[i][mid + j];
                    sum += farm[i][mid - j];
                }
            }
            System.out.println("#" + test_case + " " + sum);

        }
    }
}
