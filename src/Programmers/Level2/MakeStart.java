package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class MakeStart {
    public static void main(String[] args) {
        MakeStart sol = new MakeStart();
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] answer = sol.solution(line);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public String[] solution(int[][] line) {
        Set<int[]> set = new HashSet<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;
        for (int i = 0; i < line.length; i++) {
            long A = line[i][0], B = line[i][1], E = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long C = line[j][0], D = line[j][1], F = line[j][2];
                if(A*D - B*C == 0) continue;
                if((B*F - E*D) % (A*D - B*C) != 0 || (E*C - A*F)%(A*D - B*C) != 0) continue;
                long x = (B*F - E*D) / (A*D - B*C), y = (E*C - A*F)/(A*D - B*C);
                set.add(new int[]{(int)x, (int)y});
                minX = Math.min(minX, (int)x);
                maxX = Math.max(maxX, (int)x);
                maxY = Math.max(maxY, (int)y);
                minY = Math.min(minY, (int)y);
            }
        }
        int y = maxY - minY + 1;
        int x = maxX - minX + 1;
        char[][] charArr = new char[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                charArr[i][j] = '.';
            }
        }

        for(int[] cur : set) {
            charArr[Math.abs(cur[1] - maxY)][cur[0] - minX] = '*';
        }
        String[] answer = new String[y];
        for (int i = 0; i < y; i++) {
            answer[i] = new String(charArr[i]);
        }

        return answer;
    }
}
