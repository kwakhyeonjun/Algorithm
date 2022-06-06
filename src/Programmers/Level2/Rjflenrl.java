package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

// 15:28 ~ 15:54
public class Rjflenrl {
    public static void main(String[] args) {
        Rjflenrl sol = new Rjflenrl();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = sol.solution(places);
        for(int a : answer) {
            System.out.print(a + " ");
        }
    }

    /**
     * 5x5
     * 3 이상의 거리
     * 둘사이에 파티션으로 막혀있으면 가능
     * P : 앉아있는 자리
     * O : 테이블
     * X : 파티션
     * DFS
     * @param places 5개의 대기실 상황
     * @return : 5개의 대기실별로 거리두기 준수 여부 -  1: 지킴 / 2: 안지킴
     */
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int t = 0; t < 5; t++) {

            // 현재 사무실
            map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = places[t][i].charAt(j);
                }
            }
            visited = new boolean[5][5];
            pos = true;

            // 맵 전체 순회
            for(int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if('P' == map[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            answer[t] = pos?1:0;

        }

        return answer;
    }

    private char[][] map;
    private boolean[][] visited;
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean pos;

    private void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(map[nx][ny] == 'X') continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 'P') {
                    if(cur[2] + 1 <= 2) pos = false;
                    return;
                }

                queue.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
    }
}
