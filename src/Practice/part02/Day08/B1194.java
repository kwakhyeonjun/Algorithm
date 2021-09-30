package Practice.part02.Day08;

import java.io.*;
import java.util.*;

public class B1194 {

    private static int N;
    private static int[][] map;

    static class Edge implements Comparable<Edge>{
        int v, weight;

        public Edge(int v, int weight){
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            check = new boolean[N][N];

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            Edge[] D = new Edge[N];


            System.out.println(dist[N-1]);
        }
    }

    private static int[][] dist;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] check;
}