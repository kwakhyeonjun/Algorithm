package Practice.part02.Day09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {

    private static int N, M, R, C, L;
    private static int[][] map;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] drain = {{0, 1, 2, 3}, {2, 3}, {0, 1}, {3, 0}, {0, 2}, {1, 2}, {1, 3}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지도 세로
            M = Integer.parseInt(st.nextToken()); // 지도 가로
            R = Integer.parseInt(st.nextToken()); // 맨홀 세로위치
            C = Integer.parseInt(st.nextToken()); // 맨홀 가로위치
            L = Integer.parseInt(st.nextToken()); // 걸린 시간
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;
            bfs();

            bw.write("#" + test_case + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int answer;

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        visited[R][C] = true;
        q.add(new int[]{R, C, 1});
        answer++;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int curCount = cur[2];

            // queue에 넣는 순간 카운팅 했으므로 ㄱㅊ?
            if(curCount == L) continue;

            // drain[map[x][y] - 1]이 현재 구조물에서 이동할 수 있는 방향을 나타냄.
            int[] curDrain = drain[map[x][y] - 1];

            // 현재 map에 있는 구조물 모양에 따라 반복 횟수 달라짐.
            for (int i = 0; i < curDrain.length; i++) {
                // drain에는 이동할 방향에 대한 인덱스를 포함하므로 dir에서 다음 위치를 가져올 수 있음.
                int nx = x + dir[curDrain[i]][0];
                int ny = y + dir[curDrain[i]][1];

                // 범위 밖인 경우 continue
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 이미 방문한 경우 continue
                if(visited[nx][ny]) continue;

                // map[x][y] == 0 인 경우 이동할 수 없음.
                if(map[nx][ny] == 0) continue;

                // 들어가는 곳으로 입구가 연결된 파이프가 아니라면 continue
                // curDrain[i]에 따라 map[nx][ny]의 파이프 방향을 확인해야함.HOW???
                // 0 <> 1, 2 <> 3
                if(!isPipe(curDrain[i], nx, ny)) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, curCount+1});
                answer++;
            }
        }
    }

    private static boolean isPipe(int cur, int x, int y){
        int[] nextDrain = drain[map[x][y] - 1];
        if(cur == 0){
            for (int i = 0; i < nextDrain.length; i++) {
                if(nextDrain[i] == 1) return true;
            }
            return false;
        }
        else if(cur == 1){
            for (int i = 0; i < nextDrain.length; i++) {
                if(nextDrain[i] == 0) return true;
            }
            return false;
        }
        else if(cur == 2){
            for (int i = 0; i < nextDrain.length; i++) {
                if(nextDrain[i] == 3) return true;
            }
            return false;
        }
        else{
            for (int i = 0; i < nextDrain.length; i++) {
                if(nextDrain[i] == 2) return true;
            }
            return false;
        }
    }
}
