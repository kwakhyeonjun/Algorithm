package SWEA.D3;

import java.util.Scanner;

/**
 * N개의 격자판
 * .과 #로 이루어질 때,
 * #들이 하나의 정사각형을 이루는지 판단
 */
public class SWEA13732 {

    private static int N;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new char[N][N];
            sc.nextLine();
            for(int i = 0; i < N; i++) {
                String cur = sc.nextLine();
                map[i] = cur.toCharArray();
            }

            visited = new boolean[N][N];
            System.out.println("#" + t + " " + (find()?"yes":"no"));
        }
    }

    private static boolean find(){
        boolean found = false;
        // 사각형의 왼쪽 맨 위 찾기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                visited[i][j] = true;

                // 제일 왼쪽, 위를 찾은 경우
                if(map[i][j] == '#') {
                    // 이미 찾은 경우
                    if(found) return false;
                    found = true;
                    // 처음 찾은 경우
                    row = i; col = j;
                    if(!findRec()) return false;
                }
            }
        }
        return true;
    }

    private static int row, col;
    private static boolean findRec() {
        int curRow = 0;
        int maxCol = 0;
        for(int i = col; i < N; i++) {
            int curCol = 0;
            if(map[i][row] != '#') break;
            for (int j = row; j < N; j++) {
                visited[i][j] = true;
                if(i == col && map[i][j] == '#') {
                    maxCol++;
                }
                if(map[i][j] == '#') {
                    curCol++;
                }
            }
            if(maxCol == 1) return false;
            if(maxCol != curCol) return false;
            curRow++;
        }
        if(maxCol != curRow) return false;
        return true;
    }
}
