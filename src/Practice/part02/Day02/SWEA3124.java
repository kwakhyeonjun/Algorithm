package Practice.part02.Day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA3124 {

    private static int V, E;
    private static int[] parents;
    private static List<Edge> edges;

    private static class Edge {
        int a;
        int b;
        int weight;

        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }

    private static void make(){
        for(int i = 0; i < V; i++){
            parents[i] = i;
        }
    }

    private static int find(int a){
        if(a==parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            parents = new int[V + 1];
            edges = new ArrayList<>();

            make();

            long answer = 0;
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                edges.add(new Edge(A, B, C));
            }
            Collections.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.weight - o2.weight;
                }
            });

            for(Edge edge : edges){
                if(find(edge.a) != find(edge.b)){
                    union(edge.a, edge.b);
                    answer += edge.weight;
                }
            }

            System.out.println("#" + test_case + " " + answer );
        }
    }
}
