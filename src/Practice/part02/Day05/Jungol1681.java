package Practice.part02.Day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        perm(0, 0, 0);
        System.out.println(min);
    }

    private static int N, min;
    private static int[][] matrix;
    private static boolean[] visited;

    private static void perm(int count, int cur, int sum){
        if(count == N -1){
            if(matrix[cur][0] == 0) return;
            sum += matrix[cur][0];
            min = Math.min(min, sum);
            return;
        }
        for (int i = 1; i < N; i++) {
            if(visited[i]) continue;
            if(matrix[cur][i] == 0) continue;
            if(sum + matrix[cur][i] >= min) continue;

            visited[i] = true;
            perm(count + 1, i, sum + matrix[cur][i]);
            visited[i] = false;
        }
    }
}
