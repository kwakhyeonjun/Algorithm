package Practice.Day08;

import java.io.*;
import java.util.StringTokenizer;

public class B16926 {
    private static final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 오, 아래, 왼, 위
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t = 0; t < r; t++) {
            int countX = n - 1;
            int countY = m - 1;
            for (int idx = 0; idx < n / 2 && idx < m / 2; idx++) {
                int x = idx;
                int y = idx;
                int dir = 0;
                for (int i = 0; i < countY; i++) {
                    int nx = 0, ny = 0;
                    if (isInArray(arr, x + direction[dir][0], y + direction[dir][1])) {
                        nx = x + direction[dir][0];
                        ny = y + direction[dir][1];
                        swap(arr, x, y, nx, ny);
                    }
                    x = nx;
                    y = ny;
                }
                dir = (dir + 1) % 4;
                for (int i = 0; i < countX; i++) {
                     int nx = 0, ny = 0;
                    if (isInArray(arr, x + direction[dir][0], y + direction[dir][1])) {
                        nx = x + direction[dir][0];
                        ny = y + direction[dir][1];
                        swap(arr, x, y, nx, ny);
                    }
                    x = nx;
                    y = ny;
                }
                dir = (dir + 1) % 4;
                for (int i = 0; i < countY; i++) {
                    int nx = 0, ny = 0;
                    if (isInArray(arr, x + direction[dir][0], y + direction[dir][1])) {
                        nx = x + direction[dir][0];
                        ny = y + direction[dir][1];
                        swap(arr, x, y, nx, ny);
                    }
                    x = nx;
                    y = ny;
                }
                dir = (dir + 1) % 4;
                for (int i = 0; i < countX - 1; i++) {
                    int nx = 0, ny = 0;
                    if (isInArray(arr, x + direction[dir][0], y + direction[dir][1])) {
                        nx = x + direction[dir][0];
                        ny = y + direction[dir][1];
                        swap(arr, x, y, nx, ny);
                    }
                    x = nx;
                    y = ny;
                }
                countX -= 2;
                countY -= 2;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isInArray(int[][] arr, int x, int y){
        if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) return false;
        else return true;
    }

    private static void swap(int[][] arr, int x1, int y1, int x2, int y2){
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }
}
