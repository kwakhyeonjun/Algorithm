package Practice.part01.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  조건
 *  0. 맨 아랫줄(map[99])에서 2를 찾아 시작함.
 *  1. 다른 조건이 없다면 위로 이동
 *  2. 만약 좌/우에 1이 있다면 무조건 이동
 *      2-1. x+dx[], y+dy[]의 범위에 주의
 *  3. 위가 막혀있다면(x==0) 종료
 *
 *  해결방법
 *   - dx,dy 활용 -> 위 / 왼 / 오 사용하여 한칸씩 이동. 좌, 우에 1이 있는지 확인하고 다음칸으로 이동
 */
public class SWEA1210 {
    public static int[][] map = new int[100][100];
    public static int[] dy = {-1, 1};// 위, 왼 오
    public static int x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++){
            br.readLine();
            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            /* 0. 맨 아랫줄(map[99])에서 2를 찾아 시작함. */
            for(int i = 0; i < 100; i++){
                if(map[99][i] == 2){
                    x = 99;
                    y = i;
                }
            }
            /* 3. 위가 막혀있다면 (x==0) 종료 */
            while(x != 0){
                /* 2. 좌/우에 1이 있다면 옆으로 이동 */
                boolean isSide = false;
                map[x][y] = 0;
                for(int i = 0; i < 2; i++){
                    if(y+dy[i] >= 100 || y+dy[i] < 0) continue;
                    if(map[x][y+dy[i]] == 1){
                        y += dy[i];
                        isSide = true;
                    }
                }
                if(!isSide){
                    x -= 1;
                }
            }
            System.out.printf("#%d %d\n", test_case, y);
        }
    }
}
