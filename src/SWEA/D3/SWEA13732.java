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
            System.out.println("#" + t + " " + (find()?"yes":"no"));
        }
    }

    private static int row, col;
    private static boolean isFind;
    private static boolean[][] visit;

    private static boolean find() {
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 이미 방문한 경우
                if(visit[i][j]) continue;

                // 사각형의 왼쪽 맨 위
                if(map[i][j] == '#') {

                    // 이미 사각형을 찾은 경우
                    if(isFind) {
                        isFind = false;
                        return false;
                    }

                    // 처음으로 찾은 경우
                    isFind = true;
                    row = i;
                    col = j;
                    if(rec()) isFind = true;
                    else return false;
                }
                visit[i][j] = true;
            }
        }
        return isFind;
    }

    private static boolean rec() {
        int rowCount = 0, colCount = 0;
        for(int i = row; i < N; i++) {
            int curRowCount = 0;
            for(int j = col; j < N; j++) {
                visit[i][j] = true;
                // 첫번째 줄에서
                if(i == row) {
                    if(map[i][j] == '#') {
                        rowCount++;
                    }
                    else
                        break;
                } else {
                    if(map[i][j] == '#') {
                        curRowCount++;
                    }
                    else break;
                }
            }
            if(rowCount != curRowCount) return false;
            colCount++;
        }
        if(colCount == rowCount) return true;
        return false;
    }
}
