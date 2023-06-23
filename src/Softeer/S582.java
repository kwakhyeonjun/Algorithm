package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S582 {

    /**
     *  1. x레벨을 초과해야 도전 가능
     *  2. 포켓몬 리그에 나가기 위한 최소 레벨 이상의 소수
     */

    private static int N, M;
    private static int[][] map;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                map[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            map[A][B] = C;
            map[B][A] = C;
        }

        // dijkstra?
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for(int i = 2; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        int start = 1;
        int end = N;

        for(int t = 0; t < N; t++) {
            // find min
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= N; i++) {
                if(visited[i]) continue;
                if(min > dist[i]) {
                    start = i;
                    min = dist[i];
                }
            }

            visited[start] = true;

            // calc dist
            for(int i = 1; i <= N; i++) {
                if(visited[i]) continue;
                if(map[start][i] == Integer.MIN_VALUE) continue;

                if(dist[i] == Integer.MAX_VALUE) dist[i] = map[start][i];
                else dist[i] = Math.min(dist[i], Math.max(dist[start], map[start][i]));
            }

        }

        int answer = dist[N] + 1;
        boolean flag = true;

        while(flag) {
            flag = false;

            for(int i = 2; i * i <= answer; i++) {
                if(answer % i == 0) {
                    answer++;
                    flag = true;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
