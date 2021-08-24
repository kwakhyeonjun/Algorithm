package Practice.Day16;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA3289 {
    private static int N;
    private static int[] parents; // 1~N까지임에 주의
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            make();
            bw.write("#" + test_case + " ");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int control = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(control == 0) union(a, b);
                else{
                    int aRoot = find(a);
                    int bRoot = find(b);
                    if(aRoot == bRoot) bw.write("1");
                    else bw.write("0");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void make(){
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i; // i개의 단위집합 생성
        }
    }

    private static int find(int a){
        if(parents[a] == a) return a; // a의 부모가 자기 자신 == 대표자 노드
        else return parents[a] = find(parents[a]); // 부모노드의 부모노드를 찾으러감. path compression 적용
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot; // b가 포함되어있는 집합을 a가 포함되어있는 집합에 합침
        return true;
    }
}
