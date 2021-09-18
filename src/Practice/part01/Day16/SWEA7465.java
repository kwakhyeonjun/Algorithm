package Practice.part01.Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA7465 {
    private static int[] person;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            make();
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            Set<Integer> set = new HashSet<>();

            for(int i = 1; i <= N; i++){
                set.add(find(i));
            }
            System.out.println("#" + test_case + " " + set.size());
        }
    }

    private static void make(){
        person = new int[N+1];
        for(int i = 1; i <= N; i++){
            person[i] = i;
        }
    }

    private static int find(int v){
        if(person[v] == v) return v;
        else return person[v] = find(person[v]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        person[bRoot] = aRoot;
        return true;
    }
}
