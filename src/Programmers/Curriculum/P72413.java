package Programmers.Curriculum;

import java.util.*;

public class P72413 {

    public static void main(String[] args) {

    }

    // bfs에서 두개를 같이 돌릴 수 있나??
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        visitedA = new boolean[fares.length][fares[0].length];
        visitedB = new boolean[fares.length][fares[0].length];
        min = Integer.MAX_VALUE;

        return answer;
    }

    private boolean[][] visitedA, visitedB;
    private int min;

    private void bfs(int[][] fares, int start, int a, int b) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(start, start));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();
            if(cur.a == a && cur.b == b) {
                // 둘 다 도착한 경우
                min = Math.min(min, cur.min);
                continue;
            }
            if(cur.a != a) {
                for(int i = 0; i < fares[cur.a].length; i++) {
                    if(visitedA[cur.a][i]) continue;
                    visitedA[cur.a][i] = true;
//                    queue.add(new Pos(i, cur.a, ));
                }
            }
            if(cur.b != b) {

            }

        }
    }

    private class Pos{
        int a;
        int prevA;
        int b;
        int prevB;
        int min;

        Pos(){}

        public Pos(int a, int b) {
            this.a = a;
            this.b = b;
            min = Integer.MAX_VALUE;
        }

        public Pos(int a, int prevA, int b, int prevB, int min) {
            this.a = a;
            this.prevA = prevA;
            this.b = b;
            this.prevB = prevB;
            this.min = min;
        }
    }
}
