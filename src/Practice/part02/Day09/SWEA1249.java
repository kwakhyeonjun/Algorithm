package Practice.part02.Day09;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1249 {
    static class Edge implements Comparable<Edge>{

        int v, weight;

        public Edge(int v, int weight){
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] check = new boolean[N][N];

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            Edge[] D = new Edge[N];

            for (int i = 0; i < N; i++) {

            }
        }
    }
}
