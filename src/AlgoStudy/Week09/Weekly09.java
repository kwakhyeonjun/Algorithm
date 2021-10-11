package AlgoStudy.Week09;

import java.util.LinkedList;
import java.util.Queue;

public class Weekly09 {

    public static void main(String[] args) {
        Weekly09 sol = new Weekly09();
        sol.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
    }

    private int n, answer;
    private boolean[][] towers;
    private boolean[] visited;

    public int solution(int n, int[][] wires) {
        this.n = n;
        towers = new boolean[n+1][n+1];

        for (int[] wire : wires) {
            towers[wire[0]][wire[1]] = true;
            towers[wire[1]][wire[0]] = true;
        }

        answer = 100;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(towers[i][j]) {
                    towers[i][j] = false;
                    towers[j][i] = false;
                    countTower();
                    towers[i][j] = true;
                    towers[j][i] = true;
                }
            }
        }

        return answer;
    }

    private void countTower(){
        visited = new boolean[n+1];
        int a = 0, b = 0;

        a = bfs(1);

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) b = bfs(i);
        }

        answer = Math.min(answer, Math.abs(a-b));
    }

    private int bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        int count = 1;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                if(!visited[i] && towers[cur][i]){
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
