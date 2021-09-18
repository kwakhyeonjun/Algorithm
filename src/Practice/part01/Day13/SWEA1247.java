package Practice.part01.Day13;

import java.io.*;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    boolean isVisited;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class SWEA1247 {
    private static int N, totDistance;
    private static Node[] nodes;
    private static Node office, home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            totDistance = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            office = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            nodes = new Node[N];
            for(int i = 0; i < N; i++){
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            dfs(office);
            bw.write("#" + test_case + " " + totDistance + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(Node node){
        node.isVisited = true;
        int minDistance = Integer.MAX_VALUE;
        int nodeIdx = -1;
        for(int i = 0; i < N; i++){
            if(node == nodes[i] || nodes[i].isVisited) continue;
            int distance = getDistance(node, nodes[i]);
            if(minDistance > distance){
                minDistance = distance;
                nodeIdx = i;
            }
        }
        if(nodeIdx == -1){ // 모두 순회한 경우
            totDistance += getDistance(node, home);
            return;
        }
        totDistance += minDistance;
        dfs(nodes[nodeIdx]);
    }

    private static int getDistance(Node node1, Node node2){
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
    }

    private static void swap(int i, int j){
        Node temp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = temp;
    }
}
