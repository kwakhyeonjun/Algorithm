package Practice.part01.Day15;

import java.io.*;
import java.util.*;

public class SWEA1238 {
    private static boolean[] isVisited;
    private static boolean[][] adjMatrix;
    private static int[] levels;
    private static int maxLevel, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int test_case = 1; test_case <= 10; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            adjMatrix = new boolean[101][101];
            isVisited = new boolean[101];
            levels = new int[101];
            maxLevel = Integer.MIN_VALUE;
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to] = true;
            }
            bfs(start);
            for(int i = 1; i <= 100; i++){
                maxLevel = Math.max(levels[i], maxLevel);
            }
            for(int i = 1; i <= 100; i++){
                if(levels[i] == maxLevel){
                    max = Math.max(max, i);
                }
            }

            bw.write("#" + test_case + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> last = new ArrayList<>();
        queue.add(v);
        isVisited[v] = true;
        levels[v] = 0;
        while(!queue.isEmpty()){
            last = new ArrayList<>();;
            int current = queue.poll();
            for(int i = 1; i <= 100; i++){
                if(!isVisited[i] && adjMatrix[current][i]){
                    levels[i] = levels[current] + 1;
                    queue.add(i);
                    isVisited[i] = true;
                    last.add(i);
                }
            }
        }
    }

}
