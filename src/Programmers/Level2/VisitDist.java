package Programmers.Level2;

public class VisitDist {
    public static void main(String[] args) {
        VisitDist sol = new VisitDist();
        String dirs = "URLD";
        System.out.println(sol.solution(dirs));
    }

    public int solution(String dirs) {
        int answer = 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][][] visited = new boolean[12][12][4];
        int mx = 11, my = 11;
        int sx = 5, sy = 5;
        int nd = -1, cd = -1;
        for(char c : dirs.toCharArray()) {
            cd = -1;
            switch(c) {
                case 'L':
                    cd = 3;
                    nd = 1;
                    break;
                case 'U':
                    cd = 0;
                    nd = 2;
                    break;
                case 'R':
                    cd = 1;
                    nd = 3;
                    break;
                case 'D':
                    cd = 2;
                    nd = 0;
                    break;
            }
            int nx = sx + dir[cd][0];
            int ny = sy + dir[cd][1];
            if(nx < 0 || nx > mx || ny < 0 || ny > my) continue;
            if(visited[sx][sy][cd] || visited[nx][ny][nd]) answer--;
            visited[sx][sy][cd] = true;
            visited[nx][ny][nd] = true;
            sx = nx; sy = ny;
            answer++;
        }
        return answer;
    }
}
