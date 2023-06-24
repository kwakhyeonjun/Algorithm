package Programmers.ret;

public class P1837 {

//    public static void main(String[] args) {
//        P1837 sol = new P1837();
//        int answer = sol.solution(7, 10, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}, 6, new int[]{1, 2, 3, 3, 6, 7});
//        System.out.println(answer);
//    }

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] map = new int[n + 1][n + 1];
        int INF = 99999999;

        for(int[] edge : edge_list) {
            int s = edge[0];
            int e = edge[1];
            map[s][e] = 1;
            map[e][s] = 1;
        }

        int[][] dp = new int[k][n + 1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n + 1; j++) {
                  dp[i][j] = INF;
            }
        }

        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                for (int l = 1; l < n + 1; l++) {
                    if(map[j][l] == 1) dp[i][j] = Math.min(dp[i][j], dp[i - 1][l]);
                }

                if(j != gps_log[i]) dp[i][j]++;
            }
        }

        if(dp[k - 1][gps_log[k - 1]] < INF) return dp[k - 1][gps_log[k - 1]];
        return -1;
    }

//    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
//        int answer = 0;
//
//        boolean[][] map = new boolean[n + 1][n + 1];
//
//        for(int[] edge : edge_list) {
//            int s = edge[0];
//            int e = edge[1];
//            map[s][e] = true;
//            map[e][s] = true;
//        }
//
//        for (int i = 0; i < k - 1; i++) {
//            int cur = gps_log[i];
//            int next = gps_log[i + 1];
//
//            if(map[cur][next]) continue;
//
//            int path = findPath(map, gps_log, n, i);
//            if(path == -1) return -1;
//            i += path;
//
//            answer += path;
//        }
//
//        return answer;
//    }
//
//    private int findPath(boolean[][] map, int[] gps_log, int n, int time) {
//        int pos = gps_log[time];
//        Queue<int[]> queue = new LinkedList<>();
//        boolean[] visited = new boolean[n + 1];
//
//        queue.add(new int[]{pos, time});
//        visited[pos] = true;
//
//        while(!queue.isEmpty()) {
//            int[] cur = queue.poll();
//
//            for(int i = 1; i <= n; i++) {
//                if(!map[cur[0]][i]) continue;
//                if(visited[i]) continue;
//
//                if(gps_log[cur[1] + 1] == i) return cur[1] - time;
//
//                queue.add(new int[]{i, cur[1] + 1});
//                visited[i] = true;
//            }
//        }
//
//        return -1;
//    }
}
