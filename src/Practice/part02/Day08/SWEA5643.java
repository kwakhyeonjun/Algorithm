package Practice.part02.Day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            boolean[][] stature = new boolean[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                stature[a][b] = true;
//                stature[b][a] = true;
            }

            int answer = 0;

            for (int i = 1; i <= N; i++) {
                boolean[] visited = new boolean[N+1];
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, 0});

                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int pos = cur[0];
                    int dir = cur[1];
                    visited[pos] = true;

                    if(dir == 0){
                        for (int j = 1; j <= N; j++) {
                            if(stature[pos][j]) visited[j] = true;
                        }
                        for (int j = 1; j <= N; j++) {
                            if(stature[j][pos]) visited[j] = true;
                        }
                    }else if(dir == 1){
                        for (int j = 1; j <= N; j++) {
                            if(stature[pos][j]) visited[j] = true;
                        }
                    }else{
                        for (int j = 1; j <= N; j++) {
                            if(stature[j][pos]) visited[j] = true;
                        }
                    }

                    boolean isVisted = true;
                    for (int j = 1; j <= N; j++) {
                        if(!visited[i]) {
                            isVisted = false;
                            break;
                        }
                    }
                    if(isVisted) answer++;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
