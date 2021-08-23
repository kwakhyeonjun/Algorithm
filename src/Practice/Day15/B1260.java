package Practice.Day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
    private static int N, M;
    private static boolean[][] adjMatrix;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjMatrix = new boolean[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = adjMatrix[to][from] = true;
        }
        boolean[] isVisited = new boolean[N+1];
        dfs(V, isVisited);
        System.out.println();

        isVisited = new boolean[N+1];
        bfs(V, isVisited);

        br.close();
    }

    /**
     * 깊이 우선 탐색
     */
    private static void dfs(int v, boolean[] isVisited){
        System.out.print(v + " ");
        isVisited[v] = true;
        for(int i = 1 ; i <= N; i++){
            if(!isVisited[i] && adjMatrix[v][i]){
                dfs(i, isVisited);
            }
        }
    }

    /**
     * 너비 우선 탐색
     */
    private static void bfs(int v, boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        isVisited[v] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for(int i = 1; i <= N; i++){
                if(!isVisited[i] && adjMatrix[current][i]){
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
