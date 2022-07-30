package Programmers.Curriculum;

import java.util.*;

public class P72413 {

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        P72413 sol = new P72413();
        System.out.println(sol.solution(n, s, a, b, fares));
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        s--;
        a--;
        b--;

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < fares.length; i++) {
            map[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
            map[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
        }

        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++) {
            dist[i] = dijkstra(map, i);
        }

        for(int i = 0; i < n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }

        return answer;
    }

    private int[] dijkstra(int[][] map, int from) {
        int n = map.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            dist[i] = map[from][i];
        }

        dist[from] = 0;
        visited[from] = true;

        for(int t = 0; t < n - 2; t++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;

            // find min
            for(int i = 0; i < n ;i++) {
                if(visited[i]) continue;
                if(min > dist[i]){
                    min = dist[i];
                    idx = i;
                }
            }

            if(idx == -1) break;
            visited[idx] = true;

            for(int i = 0; i < n; i++) {
                if(visited[i] || Integer.MAX_VALUE == map[idx][i]) continue;
                dist[i] = Math.min(dist[i], dist[idx] + map[idx][i]);
            }
        }
        return dist;
    }
}
