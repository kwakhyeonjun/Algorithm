package Practice.part02.Day10;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B17143 {

    static class Shark{
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    private static int R, C, M;
    private static List<Shark> sharks;
    private static int[][] dir = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {

        // 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sharks = new LinkedList<>();

        int answer = 0;

        // 상어 위치 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sharks.add(new Shark(
                    Integer.parseInt(st.nextToken()), // r (r,c) 
                    Integer.parseInt(st.nextToken()), // c 상어의 위치 좌표
                    Integer.parseInt(st.nextToken()), // s 속력
                    Integer.parseInt(st.nextToken()), // d 이동방향
                    Integer.parseInt(st.nextToken())  // z 크기
            ));
        }

        // 낚시왕 위치
        int fisher = 0;

        while(fisher <= C){
            if(sharks.size() == 0) break;

            // 1. 낚시왕이 오른쪽으로 한칸 이동
            fisher++;

            // 2. 낚시왕이 있는 열에 있는 상어 중 땅과 제일 가까운 상어를 잡음.
            int catchShark = -1;
            int deep = R + 1;
            for (int i = 0; i < sharks.size(); i++) {
                Shark shark = sharks.get(i);
                // 낚시왕의 위치와 상어의 위치가 다른 경우 넘어감
                if(shark.c != fisher) continue;

                // 가장 깊은 곳의 상어를 탐색
                if(deep > shark.r){
                    deep = shark.r;
                    catchShark = i;
                }
            }

            // 상어를 잡음.
            if(catchShark != -1){
                answer += sharks.get(catchShark).z;
                sharks.remove(catchShark);
            }

            // 3. 상어 이동
            for (int i = 0; i < sharks.size(); i++) {
                Shark shark = sharks.get(i);
                int nr = shark.r + dir[shark.d][0] * shark.s;
                int nc = shark.c + dir[shark.d][1] * shark.s;

                while(nc < 1 || nc > C || nr < 1 || nr > R){
                    // 벽에 부딛힌 경우 방향 바꿔서 이동
                    if (nr < 1) {
                        nr = Math.abs(nr) + 2;
                        shark.d = 2;
                    }
                    if (nr > R) {
                        nr = 2 * R - nr;
                        shark.d = 1;
                    }
                    if (nc < 1) {
                        nc = Math.abs(nc) + 2;
                        shark.d = 3;
                    }
                    if (nc > C){
                        nc = 2 * C - nc;
                        shark.d = 4;
                    }
                }


                shark.r = nr;
                shark.c = nc;
            }

            // 상어 식사
            Shark[][] map = new Shark[R + 1][C + 1];
            for (Shark shark : sharks) {
                if(map[shark.r][shark.c] != null){
                    if(map[shark.r][shark.c].z < shark.z){
                        map[shark.r][shark.c] = shark;
                    }
                }else{
                    map[shark.r][shark.c] = shark;
                }
            }

            sharks = new ArrayList<>();
            for (int i = 0; i <= R; i++) {
                for (int j = 0; j <= C; j++) {
                    if(map[i][j] != null) sharks.add(map[i][j]);
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
