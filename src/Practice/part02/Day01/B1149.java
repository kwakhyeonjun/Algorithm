package Practice.part02.Day01;

import java.util.Scanner;

public class B1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] houses = new int[N][3]; // n번집 / 빨, 초, 파 가격
        for(int i = 0; i < N; i++){
            for (int j = 0; j < 3; j++) {
                houses[i][j] = sc.nextInt();
            }
        }

        int[][] paint = new int[N][3];
        for (int i = 0; i < 3; i++) {
            paint[0][i] = houses[0][i];
        }

        for(int i = 1; i < N; i++){

            // 각 색마다 다른 두개를 더한 경우 어떤 것이 더 작은지 확인
            paint[i][0] = Math.min(houses[i][0] + paint[i-1][1], houses[i][0] + paint[i-1][2]);
            paint[i][1] = Math.min(houses[i][1] + paint[i-1][0], houses[i][1] + paint[i-1][2]);
            paint[i][2] = Math.min(houses[i][2] + paint[i-1][0], houses[i][2] + paint[i-1][1]);
        }

        int answer = Integer.MAX_VALUE;
        for(int curPaint : paint[N-1]) answer = Math.min(answer, curPaint);
        System.out.println(answer);
    }
}
