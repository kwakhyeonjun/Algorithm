package AlgoStudy.Week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13460 {
    private static int N, M;
    private static char[][] map;
    private static int[][] balls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        balls = new int[2][2];

        answer = 11;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'R'){
                    balls[0] = new int[]{i, j};
                    map[i][j] = '.';
                }else if(map[i][j] == 'B'){
                    balls[1] = new int[]{i, j};
                    map[i][j] = '.';
                }
            }
        }

        bfs();
        System.out.println(answer);
        br.close();
    }

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int answer;

    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{balls[0][0], balls[0][1], balls[1][0], balls[1][1], 0});
        int count = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int[] red = new int[]{cur[0], cur[1]};
            int[] blue = new int[]{cur[2], cur[3]};
            count = cur[4];
            int redX = red[0];
            int redY = red[1];
            int blueX = blue[0];
            int blueY = blue[1];

            for (int i = 0; i < 4; i++) {
                while (true){
                    boolean moveRed = false, moveBlue = false;
                    int redNX = redX + dir[i][0];
                    int redNY = redY + dir[i][1];

                    if(map[redNX][redNY] == 'O'){
                        answer = Math.min(answer, count + 1);
                        break;
                    }

                    if(map[redNX][redNY] == '.' && !(redNX == blueX && redNY == blueY)){
                        redX = redNX;
                        redY = redNY;
                        moveRed = true;
                    }

                    int blueNX = blueX + dir[i][0];
                    int blueNY = blueY + dir[i][1];

                    if(map[blueNX][blueNY] == 'O'){
                        break;
                    }

                    if(map[blueNX][blueNY] == '.' && !(blueNX == redX && blueNY == redY)){
                        blueX = blueNX;
                        blueY = blueNY;
                        moveBlue = true;
                    }

                    if((redX == red[0] && redY == red[1]) && (blueX == blue[0] && blueY == blue[1])){
                        break;
                    }

                    if(!moveRed && !moveBlue) {
                        if(count + 1 == 10) break;
                        queue.add(new int[]{redX, redY, blueX, blueY, count + 1});
                        break;
                    }
                }
            }
        }
    }
}
