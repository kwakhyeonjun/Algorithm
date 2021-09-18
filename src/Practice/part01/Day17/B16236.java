package Practice.part01.Day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 조건
 * 1. 더이상 먹을 수 있는 물고기가 없다면 엄마상어 호출
 * 2. 먹을 수 있는 물고기가 1마리라면 먹으러감
 * 3. 여러마리라면 가장 가까운 물고기 먹음
 * 4. 지나가야하는 칸의 개수가 최소인 물고기가 대상
 * 5. 가까운 물고기가 많다면 우선순위는,
 *      1) 가장 위에 있는 물고기
 *      2) 가장 왼쪽에 있는 물고기
 *{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}
 * {{-1, 0}, {0, -1}, {0, 1}, {0, 1}};
 */
public class B16236 {
    private static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {0, 1}};
    private static int[][] map;
    private static int[] shark, fish; // 상어 정보, 먹을 물고기 정보
    private static int N, moveCnt; // 맵 크기, 움진인 수
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) shark = new int[]{i, j, 2, 0}; // x좌표, y좌표, 상어의 크기, 먹은 물고기 수
            }
        }
        bfs();
        System.out.println(moveCnt);
    }

    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {shark[0], shark[1]}); // 시작점
        visited[shark[0]][shark[1]] = true; // 방문 체크

        int lvl = 0; // 시간을 계산하기 위해 사용
        while(!queue.isEmpty()){
            int size = queue.size();
            lvl++;
            for (int i = 0; i < size; i++) { // 해당 시간에 도달할 수 있는 위치들
                int[] loc = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nx = loc[0] + dir[d][0]; // 사방 탐색을 통해 새로운 위치 좌표를 찾음
                    int ny = loc[1] + dir[d][1];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 범위를 벗어나는 경우
                    if(visited[nx][ny]) continue;
                    if(shark[2] < map[nx][ny]) continue;

                    // 이동 가능한 경우
                    visited[nx][ny] = true;
                    // 이동만 하고 물고기는 못먹는 경우 (좌표가 0인 경우 / 물고기와 상어의 크기가 같은 경우
                    if(map[nx][ny] == 0 || shark[2] == map[nx][ny]){
                        queue.add(new int[]{nx, ny});
                        continue;
                    }
                    // 물고기 먹는 경우
                    if(fish == null){ // 해당 시간대에 물고기가 처음 발견된 경우
                        fish = new int[] {nx, ny};
                        continue;
                    }

                    //발견된 물고기가 처음이 아닌경우
                    if(fish[0] > nx || (fish[0] == nx && fish[1] > ny)){ // 물고기의 좌표 변경(더 위에있고, 같은 높이라면 더 왼쪽인지 확인)
                        fish[0] = nx;
                        fish[1] = ny;
                    }
                }
            } // 동일한 레벨에서 반복 종료

            if(fish != null) { // 동일한 레벨에서 먹을 수 있는 물고기를 찾은 경우 더이상 큐의 다음 반복을 하지 않음
                moveCnt += lvl; // 이동한 시간
                shark[3]++; // 상어가 먹은 물고기 개수 증가
                if(shark[2] == shark[3]){ // 상어의 크기만큼 물고기를 먹었다면 크기 증가시키기
                    shark[2]++;
                    shark[3] = 0;
                }
                map[shark[0]][shark[1]] = 0;
                shark[0] = fish[0];
                shark[1] = fish[1];

                queue.clear(); // 큐 초기화 : 큐에 들어있는 데이터 제거

                // 초기상태로 다시 만들어줌
                queue.add(new int[] {shark[0], shark[1]}); // 시작점
                visited = new boolean[N][N];
                visited[shark[0]][shark[1]] = true; // 방문 체크
                lvl = 0;
                fish = null;
            }
        }
    }
}
