package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class P169198 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> answer = new ArrayList<>();

        for (int[] ball : balls) {
            int min = Integer.MAX_VALUE;

            int nx, ny;

            // left (-a, b)
            int left = getDist(startX + ball[0], startY - ball[1]);

            // right (2m - a, b)
            int right = getDist(startX - (2* m - ball[0]), startY - ball[1]);

            // down (a, -b)
            int down = getDist(startX - ball[0], startY + ball[1]);

            // up (a, 2n - b)
            int up = getDist(startX - ball[0], startY - (2 * n - ball[1]));

            if(startX == ball[0]) {
                if(startY > ball[1]) {
                    min = getMin(left, right, up);
                } else {
                    min = getMin(left, right, down);
                }
            }

            else if(startY == ball[1]) {
                if(startX > ball[0]) {
                    min = getMin(right, up, down);
                } else {
                    min = getMin(left, up, down);
                }
            }

            else
                min = Math.min(left, getMin(right, up, down));

            answer.add(min);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private int getDist(int x, int y) {
        return x * x + y * y;
    }
}
