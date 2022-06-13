package Programmers.Level2;

public class Delivery {
    public static void main(String[] args) {
        Delivery sol = new Delivery();
        int N = 6;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K = 4;
        int answer = sol.solution(N, road, K);
        System.out.println(answer);
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                map[i][j] = 5000001;
            }
        }

        for (int i = 0; i < road.length; i++) {
            int[] cur = road[i];
            if(map[cur[0] - 1][cur[1] - 1] < cur[2]) continue;
            map[cur[0] - 1][cur[1] - 1] = cur[2];
            map[cur[1] - 1][cur[0] - 1] = cur[2];
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(map[0][i] <= K) answer++;
        }

        return answer;
    }
}
