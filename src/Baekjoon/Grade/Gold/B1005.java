package Baekjoon.Grade.Gold;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            Node[] nodes = new Node[n];
            input = br.readLine().split(" ");
            for(int i = 0; i < n; i++) {
                nodes[i] = new Node(Integer.parseInt(input[i]));
            }

            for(int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int from = Integer.parseInt(input[0]);
                int to = Integer.parseInt(input[1]);

            }

            int win = Integer.parseInt(br.readLine());


        }
    }

    private static Node findParent(Node node) {
        if(node == node.parent) return node;
        return findParent(node.parent);
    }

    private static class Node {
        int value;
        Node parent;

        Node() {}
        Node(int value) {
            this.value = value;
            parent = this;
        }
    }
}
