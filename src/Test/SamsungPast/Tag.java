package Test.SamsungPast;

import java.util.*;
import java.io.*;

public class Tag {

    private static int n, m, h, k;
    private static Pos tagger;
    private static List<Pos> runners, trees;

    public static void main(String[] args) throws IOException {
        // Your Program Goes Here
        int answer = 0;

        // 0. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmhk = br.readLine().split(" ");

        n = Integer.parseInt(nmhk[0]);
        m = Integer.parseInt(nmhk[1]);
        h = Integer.parseInt(nmhk[2]);
        k = Integer.parseInt(nmhk[3]);

        // 도망자 위치
        runners = new ArrayList<>();
        // 나무 위치
        trees = new ArrayList<>();

        // 도망자 input
        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            runners.add(new Pos(
                    Integer.parseInt(input[0]) - 1,
                    Integer.parseInt(input[1]) - 1,
                    Integer.parseInt(input[2])));
        }

        // 나무 input
        for(int i = 0; i < h; i++) {
            String[] input = br.readLine().split(" ");
            trees.add(new Pos(
                    Integer.parseInt(input[0]) - 1,
                    Integer.parseInt(input[1]) - 1));
        }

        tagger = new Pos(n/2, n/2, 0);

        visited = new boolean[n][n];
        // 0. 종료

        // k번 반복
        for(int t = 1; t <= k; t++) {
//            System.out.println("t= " + t);

            // 1. m명의 도망자가 동시에 움직임
            moveRunner();

            // 2. 술래가 움직임
            int count = moveTagger();

            answer += count * t;
        }

        System.out.println(answer);
    }

    private static int moveTagger() {

        // 1) 1턴에 한칸
        int x = tagger.x;
        int y = tagger.y;
        int d = tagger.d;
        tagger.x = x + dir[order[d]][0];
        tagger.y = y + dir[order[d]][1];

        // 2) 이동 후에 방향이 바뀌는 곳이라면 바로 방향을 틀어줌
        tagger.d = taggerTurn(x, y, d);

//        System.out.println("tagger= " + tagger);
        // 4) 현재 바라보고 있는 방향으로 3칸에 있는 도망자를 잡음.
        return catchRunner();
    }

    private static int catchRunner() {
        int count = 0;
        for(Pos runner : runners) {
            if(runner.death) continue;
            boolean impos = false;
            for(Pos tree : trees) {
                // 5) 나무가 있는 칸이면 잡을 수 없음
                if(tree.x == runner.x && tree.y == runner.y){
                    impos = true;
                    break;
                }
            }
            if(impos) continue;

            int tx = tagger.x;
            int ty = tagger.y;
            int td = tagger.d;

            // 바라보는 방향으로 3칸
            for(int i = 0; i < 3; i++) {
                int cx = tx + dir[order[td]][0] * i;
                int cy = ty + dir[order[td]][1] * i;

                if(!isInMap(cx, cy)) continue;

                if(runner.x == cx && runner.y == cy) {
//                    System.out.println("dead runner= " + runner);
                    count++;
                    runner.death = true;
                }
            }
        }
        return count;
    }

    private static boolean[][] visited;
    private static boolean isBack;

    private static int taggerTurn(int x, int y, int d) {
        if(!isBack) d += 1;
        else d -= 1;
        if(d == 4) d = 0;
        if(!visited[x + dir[order[d]][0]][y + dir[order[d]][1]]) return d;
        // 3) (0, 0)이나 중앙인 경우에도 바로 방향을 틀어줘야함.
        if(x == 0 && y == 0) {
            isBack = true;
            return 2;
        }
        if(x == (n/2) && y == (n/2)) {
            isBack = false;
            return 0;
        }

        return d;
    }

    private static void moveRunner() {
//        System.out.println("Runners");
        for(Pos runner : runners) {
            if(runner.death) continue;
            int x = runner.x;
            int y = runner.y;
            int d = runner.d;

            // 1) 술래와의 거리가 3 이하인 도망자만 움직임
            if(getDist(x, y, tagger.x, tagger.y) > 3) continue;

            // 3) 이동
            // 가) 다음 위치가 격자를 벗어나는지 확인, 벗어난다면 뒤로 돎
            if(!isInMap(x + dir[d][0], y + dir[d][1])) d = turn(d);

            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            // 나) 움직이려는 칸에 술래가 있다면 움직이지 않음
            if(tagger.x == nx && tagger.y == ny) continue;

            // 다) 앞으로 한 칸 이동
            runner.x = x + dir[d][0];
            runner.y = y + dir[d][1];
            runner.d = d;
//            System.out.println(cur);
        }
    }

    private static int turn(int d) {
        if(d == 0) return 1;
        else if(d == 1) return 0;
        else if(d == 2) return 3;
        else return 2;
    }

    private static boolean isInMap(int x, int y) {
        if(x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }

    private static final int[] order = {3, 1, 2, 0};

    private static final int[][] dir = {
            {0, -1}, {0, 1}, // 좌우 (d == 1) 왼, 오
            {1, 0}, {-1, 0}  // 상하 (d == 2) 하, 상
    };

    static class Pos {
        int x;
        int y;
        int d; // 1: 좌우 - 오른쪽 보고 시작, 2: 상하 - 아래보고 시작
        boolean death;
        Pos(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.death = false;
        }

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
            this.death = false;
        }

        public String toString() {
            return "x= " + this.x + ", y= " + this.y + ", d = " + this.d;
        }
    }

    // 1 - 2) 둘 사이의 거리는 |x1 - x2| + [y1 - y2|
    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}