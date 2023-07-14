package Programmers.ret;

public class P12978 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N][N];

        final int INF = 500_001;

        int[] dist = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = INF;
            }
            dist[i] = INF;
        }

        for (int[] cur : road) {
            int a = cur[0] - 1;
            int b = cur[1] - 1;
            int d = cur[2];

            map[a][b] = Math.min(map[a][b], d);
            map[b][a] = Math.min(map[b][a], d);
        }

        dist[0] = 0;
        visited[0] = true;

        for (int t = 0; t < N; t++) {
            int min = INF;
            int idx = 0;

            for (int i = 0; i < N; i++) {
                if(!visited[i] && dist[i] < min) {
                    min = dist[i];
                    idx = i;
                }
            }

            visited[idx] = true;

            for (int i = 0; i < N; i++) {
                dist[i] = Math.min(dist[i], dist[idx] + map[idx][i]);
            }
        }

        for (int i = 0; i < N; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
}
