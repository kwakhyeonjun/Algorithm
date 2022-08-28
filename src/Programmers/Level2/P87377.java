package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class P87377 {
    public static void main(String[] args) {

    }

    public String[] solution(int[][] line) {
        Set<int[]> set = new HashSet<>();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            long A = line[i][0], B = line[i][1], C = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                long D = line[j][0], E = line[j][1], F = line[j][2];

                // 분모 == 0
                if ((B * D - A * E) == 0 || (A * E - B * D) == 0) continue;

                // 정수가 아닌 경우
                if( (C * E - B * F) % (B * D - A * E) != 0 || (C * D - A * F) % (A * E - B * D) != 0) continue;

                long x = (C * E - B * F) / (B * D - A * E);
                long y = (C * D - A * F) / (A * E - B * D);

                // 저장
                set.add(new int[]{(int)x, (int)y});
                minX = Math.min(minX, (int) x);
                maxX = Math.max(maxX, (int) x);
                minY = Math.min(minY, (int) y);
                maxY = Math.max(maxY, (int) y);
            }
        }

        int x = maxX - minX + 1;
        int y = maxY - minY + 1;
        char[][] charArr = new char[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                charArr[i][j] = '.';
            }
        }

        for (int[] cur : set) {
            charArr[Math.abs(cur[1] - maxY)][cur[0] - minX] = '*';
        }
        String[] answer = new String[y];
        for (int i = 0; i < y; i++) {
            answer[i] = new String(charArr[i]);
        }
        return answer;
    }
}
