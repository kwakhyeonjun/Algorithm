package Baekjoon.Grade.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1238 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int fr = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int ti = Integer.parseInt(st.nextToken());

            map[fr][to] = ti;
        }

        int answer = 0;

        int[][] toDist = new int[n][n];
        int[] comebackDist = dijkstra(map, x);

        for(int from = 0; from < n; from++) {
            toDist[from] =  dijkstra(map, from);
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, toDist[i][x] + comebackDist[i]);
        }
        System.out.println(answer);
    }

    private static int[] dijkstra(int[][] map, int from) {
        int n = map.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[from] = 0;
        visited[from] = true;

        for (int i = 0; i < n; i++) {
            if(!visited[i] && map[from][i] != Integer.MAX_VALUE) {
                dist[i] = map[from][i];
            }
        }

        for(int t = 0; t < n-1; t++) {
            int min = Integer.MAX_VALUE;
            int idx = 0;

            for(int i = 0; i < n; i++) {
                if(i == from || visited[i]) continue;
                if(min > dist[i]) {
                    min = dist[i];
                    idx = i;
                }
            }
            visited[idx] = true;

            for(int i = 0; i < n; i++) {
                if(map[idx][i] == Integer.MAX_VALUE) continue;
                dist[i] = Math.min(dist[i], dist[idx] + map[idx][i]);
            }
        }

        return dist;
    }
}
