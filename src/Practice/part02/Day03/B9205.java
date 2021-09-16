package Practice.part02.Day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9205 {

    private static class Node {
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++){
            int n = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[n + 2];
            for(int i = 0; i < n + 2; i++){
                st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            boolean[][] map = new boolean[n+2][n+2];

            for(int i = 0; i < n + 2; i++){
                for (int j = 0; j < n + 2; j++) {
                    if(getDistance(nodes[i], nodes[j]) <= 1000) {
                        map[i][j] = true;
                        map[j][i] = true;
                    }
                }
            }

            for(int k = 0; k < n + 2; k++){
                for(int i = 0; i < n + 2; i++){
                    for (int j = 0; j < n + 2; j++) {
                        if(i == j) continue;
                        if(map[i][k] && map[k][j]) map[i][j] = true;
                    }
                }
            }
            System.out.println(map[0][n+1] ? "happy" : "sad");
        }
    }

    private static int getDistance(Node node1, Node node2){
        int x1 = node1.x;
        int y1 = node1.y;
        int x2 = node2.x;
        int y2 = node2.y;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}