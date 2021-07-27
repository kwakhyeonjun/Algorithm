package Baekjoon;

import java.util.Scanner;

public class B2615 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 구현하세요.

        int[][] matrix = new int[19][19];
        int[] dx = {0, 1, -1, 1}; // 순서대로 오른쪽, 대각선 아래, 대각선 위 , 아랫쪽 어디다가 팔아먹었냐 미치광이야
        int[] dy = {1, 1, 1, 0}; // 이전돌을 확인하기 위해서 -dx, -dy 사용

        //!!!!!!!!!! 줄 넘버 확인 !!!!!!!!!!!!
        // input
        for(int x = 0; x < 19; x++) {
            for(int y = 0; y < 19; y++) {
                matrix[x][y] = sc.nextInt();
            }
        }

        // output
        // 현재 칸부터 순회 시작하므로 1부터 시작 , 5개가 되는 타이밍에 확인
        int count = 1;

        for(int x = 0; x< 19; x++) {
            for(int y = 0; y < 19; y++) { // 가로줄에서 굳이 오른쪽 끝 5칸 범위를 탐색할 필요 없음
                if(matrix[x][y] == 1 || matrix[x][y] == 2) { // 흑, 백 동시에 순회하여 속도 확보
                    for(int i = 0; i < 4; i++) { // dx, dy 순회 == 방향순회
                        int nx = x; // dx, dy를 계속 더해가며 확인하기 위함
                        int ny = y;
                        for(int j = 0; j < 4; j++) { // 5칸 확인 및 6번째, 이전칸 확인
                            nx += dx[i];
                            ny += dy[i];
                            if(isInner(matrix, nx, ny) && matrix[nx][ny] == matrix[x][y]) {
                                count++;
                                if(count == 5) {
                                    // 6번째에 같은돌이 있는 경우
                                    nx += dx[i];
                                    ny += dy[i];
                                    if(isInner(matrix, nx, ny) && matrix[nx][ny] == matrix[x][y]) { // 같은 돌이 있는 경우
                                        count = 1;
                                        break;
                                    }
                                    // 이전 돌이 같은 경우 ( 6번째 케이스랑 변수 겹치지만 영향 없음 )
                                    nx = x - dx[i]; // 시작위치에서 방향의 반대방향을 search
                                    ny = y - dy[i];
                                    if(isInner(matrix, nx, ny) && matrix[nx][ny] == matrix[x][y]) { // 같은 돌이 있는 경우
                                        count = 1;
                                        break;
                                    }
                                    System.out.printf("%d\n%d %d", matrix[x][y], x + 1, y + 1); // 0부터 시작했으므로 각각 +1
                                    return;
                                }
                            }else {
                                count = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("0");
    }

    /**
     * 19x19 바툭판 내부에 있는지 확인
     * @param matrix : 19x19 바둑판
     * @param x : nx 사용
     * @param y : ny 사용
     * @return 내부면 true, 외부면 false
     */
    public static boolean isInner(int[][] matrix, int x, int y) {
        if(x >= 0 && x < 19 && y >= 0 && y < 19) return true;
        else return false;
    }

}

