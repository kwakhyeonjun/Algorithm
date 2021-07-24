package SWEA.D2;

import java.util.Scanner;

public class SWEA1979_fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean isWord = true;
        for(int test_case = 1; test_case <= T; test_case++){
            int count = 0;
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int n = 0; n < N; n++){
                for(int m = 0; m < N; m++){
                    /*
                     * case check - 단어가 들어가는 경우
                     * 1. 왼쪽 막혀있는 경우 + 오른쪽 뚫려있는 경우
                     * 2. 위 막혀있는 경우 + 아래 뚫려있는 경우
                     *
                     * + 단어 수 체크
                     */
                    if(map[n][m] == 1){
                        // case 1: 왼쪽 막힘 + 오른쪽 뚫림
                        if((m - 1 < 0 || map[n][m - 1] == 0) && (m+1 < N && map[n][m + 1] == 1) && m + K < N){
                            for(int i = 0; i < K; i++){
                                if(map[n][m+i]==0){
                                    isWord = false;
                                    break;
                                }
                            }
                            if(isWord && ( m+K == N || (m+K < N && map[n][m+K]==0))){
                                count++;
                            }
                        }
                        // case 2: 위 막힘, 오른쪽 뚤림
                        if((n - 1 < 0 || map[n-1][m] == 0 ) && (n+1 < N && map[n + 1][m] == 1) && n + K < N){
                            for(int i = 0; i < K; i++){
                                if(map[n+i][m]==0){
                                    isWord = false;
                                    break;
                                }
                            }
                            if(isWord && ( n+K == N || (n+K < N && map[n+K][m]==0))){
                                count++;
                            }
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}
