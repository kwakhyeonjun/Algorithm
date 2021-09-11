package Test.Kakao;

import java.util.ArrayList;
import java.util.List;

public class Sol5 {

    public static void main(String[] args) {
        Sol5 sol = new Sol5();
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edge = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        System.out.println(sol.solution(info, edge));
    }

    public int solution(int[] info, int[][] edges) {

        int N = info.length;
        tree = new Node[N];
        for(int i = 0; i < N; i++) tree[i] = new Node();

        // 트리 setting
        for(int i = 0; i < edges.length; i++){
            tree[edges[i][0]].setLinked(edges[i][1]);
        }

        for(int i = 0; i < N; i++){
            tree[i].setAnimal(info[i]);
        }

        int[] dir = new int[N];
        boolean[] visited;

        for(int i = 1; i < N; i++){
            if(info[i] == 0){
                wolf = 0;
                min = Integer.MAX_VALUE;
                visited = new boolean[N];
                dfs(0, i, visited);
                dir[i] = min;
            }
        }
        int sheepN = 0;
        for(int i = 0; i < N; i++){
            if(info[i] == 0) sheepN++;
        }

        int sheep = 1;
        wolf = 0;
        visited = new boolean[N];
        visited[0] = true;
        int idx = 0;
        for(int k = 1; k < sheepN; k++) {
            int minWolf = Integer.MAX_VALUE;
            for(int i = 1; i < N; i++) {
                if(info[i] == 0 && minWolf > dir[i] && !visited[i]) {
                    minWolf = dir[i];
                    idx = i;
                }
            }
            min = Integer.MAX_VALUE;
            if(info[idx] == 0 && dir[idx] < sheep && !visited[idx] && wolf < sheep){
                sheep++;
                visited[idx] = true;
                dfs(0, idx, visited);
                wolf += min;
            }
        }
        return sheep;
    }

    Node[] tree;
    int wolf, min = Integer.MAX_VALUE;

    public void dfs(int idx, int dest, boolean[] visited){
        Node curNode = tree[idx];
        if(dest == idx && min > wolf) {
            min = wolf;
            return;
        }
        if(curNode.getAnimal() == 1 && !visited[idx]) wolf++;
        for(int i : curNode.getLinked()){
            dfs(i, dest, visited);
        }
        if(curNode.getAnimal() == 1) wolf--;
    }

    class Node{
        private List<Integer> linked = new ArrayList<>();
        private int animal;

        public Node(){};

        public List<Integer> getLinked() {
            return linked;
        }

        public Node setLinked(int next) {
            linked.add(next);
            return this;
        }

        public int getAnimal() {
            return animal;
        }

        public Node setAnimal(int animal) {
            this.animal = animal;
            return this;
        }
    }
}
