package Test.AlgoContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, H, map[][];
    private static boolean isArrived;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //맵 사이즈
            H = Integer.parseInt(st.nextToken()); //남은 체력
            map = new int[N][N];				  //맵
            for(int i = 0 ; i < N ; i ++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isArrived = false;
            visited = new boolean[N][N];
            solution(0, 0);
            System.out.println(isArrived ? "true ending" : "bad ending");
        }
    }

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean[][] visited;

    private static class Pos {
        int x, y, H;
        public Pos(int x, int y, int H){
            this.x = x;
            this.y = y;
            this.H = H;
        }
    }
    private static void solution(int x, int y){
        Queue<Pos> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Pos(x, y, H));
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            System.out.println(cur.x +", " + cur.y + ", " + cur.H);

            // 도착한 경우
            if(cur.x == N-1 && cur.y == N-1 && cur.H >= 0){
                isArrived = true;
                return;
            }

            // 체력 모두 소진한 경우
            if(cur.H <= 0) continue;

            // 사방 탐색
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                // 맵 밖으로 나가는 경우
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                // 벽인 경우
                if(map[nx][ny] == 1) continue;

                // 이미 방문한 경우
                if(visited[nx][ny]) continue;

                // 다음 칸에 방문 표시
                visited[nx][ny] = true;

                // 아이템 먹는 경우
                if(map[nx][ny] == 2) {
                    queue.offer(new Pos(nx, ny, cur.H + 1));
                    continue;
                }

                // 빈칸인 경우
                queue.offer(new Pos(nx, ny, cur.H - 1));
            }


        }
    }
}
