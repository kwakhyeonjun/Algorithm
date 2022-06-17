package Programmers.Level2;

public class Qhrwhrdl {
    public static void main(String[] args) {
        Qhrwhrdl sol = new Qhrwhrdl();
        System.out.println(sol.solution(4));
    }

    public int[] solution(int n) {
        final int max = Integer.MAX_VALUE;
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                arr[i][j] = max;
            }
        }

        int index = 1, di = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};

        int x = 0, y = 0;

        while(index <= size) {
            arr[x][y] = index++;

            if(x == 0 || (x < n-1 && y > 0 && arr[x + 1][y] == 0 && arr[x][y - 1] != 0)) di = 0;
            else if(y == x || (x > 0 && y > 0 && y < n - 1 && arr[x-1][y-1] == 0 && arr[x][y+1] != 0)) di = 2;
            else if(x == n - 1 || (x < n -1 && y < n - 1 && arr[x][y + 1] == 0 && arr[x+1][y] != 0)) di = 1;


            x += dir[di][0];
            y += dir[di][1];
        }

        int ai = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[ai++] = arr[i][j];
            }
        }
        return answer;
    }
}
