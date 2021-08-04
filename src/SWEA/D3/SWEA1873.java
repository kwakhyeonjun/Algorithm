package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  문자	    의미
 *  .   	평지(전차가 들어갈 수 있다.)
 *  *   	벽돌로 만들어진 벽
 *  #	    강철로 만들어진 벽
 *  -   	물(전차는 들어갈 수 없다.)
 *  ^   	위쪽을 바라보는 전차(아래는 평지이다.)
 *  v   	아래쪽을 바라보는 전차(아래는 평지이다.)
 *  <   	왼쪽을 바라보는 전차(아래는 평지이다.)
 *  >   	오른쪽을 바라보는 전차(아래는 평지이다.)
 *
 *
 * 문자	 동작
 *  U	 Up    : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
 *  D	 Down  : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
 *  L	 Left  : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
 *  R	 Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
 *  S	 Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 *
 *  전차 이동 직후에는 반드시 .으로 변경
 *  전차가 이동을 하려고 할 때, 만약 게임 맵 밖이라면 전차는 당연히 이동하지 않는다.
 *  전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.
 *  만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
 *  강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.
 *  게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.
 */
public class SWEA1873 {

    static char[][] map;
    static int H, W; // map size = HxW
    static int x, y; // 전차 위치(x,y)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for(int i = 0; i < H; i++){
                String temp = br.readLine();
                for(int j = 0; j < W; j++){
                    map[i][j] = temp.charAt(j);
                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        x = i;
                        y = j;
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for(int i = 0; i < n; i++){
                next(str.charAt(i));
            }

            StringBuilder sb = new StringBuilder("#");
            sb.append(test_case).append(" ");
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    sb.append(map[i][j]);
                }
                if(i!=H-1) sb.append("\n");
            }
            System.out.println(sb);
        }
    }

    private static void next(char next){
        switch (next){
            case 'U':
                if(isAbleToMove(x - 1, y)){
                    map[x][y] = '.';
                    x -= 1;
                }
                map[x][y] = '^';
                break;
            case 'D':
                if(isAbleToMove(x + 1, y)){
                    map[x][y] = '.';
                    x += 1;
                }
                map[x][y] = 'v';
                break;
            case 'L':
                if(isAbleToMove(x, y - 1)) {
                    map[x][y] = '.';
                    y -= 1;
                }
                map[x][y] = '<';
                break;
            case 'R':
                if(isAbleToMove(x, y + 1)) {
                    map[x][y] = '.';
                    y += 1;
                }
                map[x][y] = '>';
                break;
            case 'S':
                shoot(map[x][y], x, y);
                break;
        }
    }
    private static void shoot(char dir, int x, int y){
        char obj;
        int dx = 0;
        int dy = 0;
        switch(dir){
            case '^':
                dx = -1;
                break;
            case 'v':
                dx = 1;
                break;
            case '<':
                dy = -1;
                break;
            case '>':
                dy = 1;
                break;
        }
        while(true){
            if(x+dx < 0 || x+dx >= H || y+dy < 0 || y+dy >= W) break;
            x += dx;
            y += dy;
            obj = map[x][y];
            if(obj == '*'){
                map[x][y] = '.';
                break;
            }
            if(obj == '#'){
                break;
            }
        }
    }
    private static boolean isAbleToMove(int x, int y){
        if(x < 0 || x >= H || y < 0 || y >= W || map[x][y] == '#' || map[x][y] == '*' || map[x][y] == '-') return false;
        return true;
    }
}
