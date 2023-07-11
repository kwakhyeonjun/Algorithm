package Programmers.ret;

public class P12952 {
    public int solution(int n) {
        this.answer = 0;
        this.n = n;

        visited = new boolean[n][n];
        dfs(0);

        return answer;
    }

    private boolean[][] visited;
    private int n, answer;

    private void dfs(int count) {
        if(count == n) {
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visited[count][i]) continue;
            if(!check(count, i)) continue;
            visited[count][i] = true;
            // System.out.println("x = " + count + ", y = " + i);
            dfs(count + 1);
            visited[count][i] = false;
        }
    }

    private final int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private boolean check(int x, int y) {
        for(int i = 0; i < 8; i++) {
            int nx = x;
            int ny = y;
            while(true){
                nx += dir[i][0];
                ny += dir[i][1];
                if(!isInMap(nx, ny)) break;
                if(visited[nx][ny]) return false;
            }
        }
        return true;
    }


    private boolean isInMap(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
