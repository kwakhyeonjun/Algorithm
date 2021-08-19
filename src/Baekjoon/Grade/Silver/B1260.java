package Baekjoon.Grade.Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int no;
    boolean isVisited;
    List<Node> nodes = new ArrayList<>();
    Node(int no){
        this.no = no;
    }
}

public class B1260 {
    private static Node[] nodes;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        nodes = new Node[N+1];
        for(int i = 1; i <= N; i++){
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            nodes[fromNode].nodes.add(nodes[toNode]);
        }
        dfs(V);
        bw.write("\n");

        for(int i = 1; i <= N; i++)
            nodes[i].isVisited = false;

        bw.write(V + " ");
        bfs(V);
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 깊이우선탐색
     */
    private static void dfs(int start) throws IOException{
        Node currentNode = nodes[start];
        bw.write(start + " ");
        currentNode.isVisited = true;
        if(currentNode.nodes.size() != 0){
            for(Node node : currentNode.nodes){
                if(!node.isVisited) dfs(node.no);
            }
        }
    }

    /**
     * 너비우선탐색
     */
    private static void bfs(int start) throws IOException{
        Node currentNode = nodes[start];
        currentNode.isVisited = true;
        if(currentNode.nodes.size() != 0){
            for(Node node : currentNode.nodes){
                if(!node.isVisited) {
                    node.isVisited = true;
                    bw.write(node.no + " ");
                }
            }
            for(Node node : currentNode.nodes){
                bfs(node.no);
            }
        }
    }
}
